package net.pazz.yto.lock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Peng Jian
 * @date: 2018/6/15 11:12
 * @description:
 * 使用Redis提供分布式锁的{@link LockRegistry}的实现。 锁被存储在密钥 {@code registryKey：lockKey} 下。
 * 锁定（默认60秒）后过期。 解锁过期锁的线程将获得 {@link IllegalStateException} 。 这应该被认为是一个严重的错误，因为受保护的资源可能受到损害。
 * 锁是可重入的。
 * 然而，锁是由注册表限定的; 来自不同注册表的锁具有相同的密钥（即使注册表使用相同的'registryKey'）是不同的锁定，
 * 而第二个不能在第一个锁定时由同一个线程获取。
 * 注意：这不适用于低延迟应用程序。它旨在跨多个JVM进行资源锁定。
 */
public final class RedisLockRegistry implements ExpirableLockRegistry {

    private static final Log logger = LogFactory.getLog(RedisLockRegistry.class);

    private static final long DEFAULT_EXPIRE_AFTER = 60000;

    private static final String OBTAIN_LOCK_SCRIPT =
            "local lockClientId = redis.call('GET', KEYS[1])\n" +
                    "if lockClientId == ARGV[1] then\n" +
                    "  redis.call('PEXPIRE', KEYS[1], ARGV[2])\n" +
                    "  return true\n" +
                    "elseif not lockClientId then\n" +
                    "  redis.call('SET', KEYS[1], ARGV[1], 'PX', ARGV[2])\n" +
                    "  return true\n" +
                    "end\n" +
                    "return false";

    private final Map<String, RedisLock> locks = new ConcurrentHashMap<>();

    private final String clientId = UUID.randomUUID().toString();

    private final String registryKey;

    private final StringRedisTemplate redisTemplate;

    private final RedisScript<Boolean> obtainLockScript;

    private final long expireAfter;

    /**
     * 默认本地锁超时失效时间
     */
    private final long defaultExpireUnusedOlderThanTime;

    /**
     * Constructs a lock registry with the default (60 second) lock expiration.
     * @param connectionFactory The connection factory.
     * @param registryKey The key prefix for locks.
     */
    public RedisLockRegistry(RedisConnectionFactory connectionFactory, String registryKey) {
        this(connectionFactory, registryKey, DEFAULT_EXPIRE_AFTER,DEFAULT_EXPIRE_UNUSED_OLDER_THEN_TIME);
    }

    /**
     * Constructs a lock registry with the supplied lock expiration.
     * @param connectionFactory The connection factory.
     * @param registryKey The key prefix for locks.
     * @param expireAfter The expiration in milliseconds.
     */
    public RedisLockRegistry(RedisConnectionFactory connectionFactory, String registryKey, long expireAfter,long defaultExpireUnusedOlderThanTime) {
        Assert.notNull(connectionFactory, "'connectionFactory' cannot be null");
        Assert.notNull(registryKey, "'registryKey' cannot be null");
        this.redisTemplate = new StringRedisTemplate(connectionFactory);
        this.obtainLockScript = new DefaultRedisScript<>(OBTAIN_LOCK_SCRIPT, Boolean.class);
        this.registryKey = registryKey;
        this.expireAfter = expireAfter;
        this.defaultExpireUnusedOlderThanTime = defaultExpireUnusedOlderThanTime;
    }

    //根据key获得lock
    @Override
    public Lock obtain(Object lockKey) {
        Assert.isInstanceOf(String.class, lockKey); //验证key
        String path = (String) lockKey;
        return this.locks.computeIfAbsent(path, RedisLock::new);
    }

    @Override
    public void expireUnusedOlderThan(long age) {
        Iterator<Map.Entry<String, RedisLock>> iterator = this.locks.entrySet().iterator();
        long now = System.currentTimeMillis();
        while (iterator.hasNext()) {
            Map.Entry<String, RedisLock> entry = iterator.next();
            RedisLock lock = entry.getValue();
            if (now - lock.getLockedAt() > age && !lock.isAcquiredInThisProcess()) {
                iterator.remove();
            }
        }
    }

    @Override
    public long getDefaultExpireUnusedOlderThanTime() {
        return defaultExpireUnusedOlderThanTime;
    }

    /**
     * 内部类 RedisLock
     */
    private final class RedisLock implements Lock {

        private final String lockKey; //lockKey

        private final ReentrantLock localLock = new ReentrantLock();

        private volatile long lockedAt;

        private RedisLock(String path) {
            this.lockKey = constructLockKey(path);
        }

        private String constructLockKey(String path) {
            return RedisLockRegistry.this.registryKey + ":" + path;
        }

        public long getLockedAt() {
            return this.lockedAt;
        }

        @Override
        public void lock() {
            this.localLock.lock();
            while (true) {
                try {
                    while (!obtainLock()) {
                        Thread.sleep(100); //NOSONAR
                    }
                    break;
                }
                catch (InterruptedException e) {
                    /*
                     * This method must be uninterruptible so catch and ignore
                     * interrupts and only break out of the while loop when
                     * we get the lock.
                     */
                }
                catch (Exception e) {
                    this.localLock.unlock();
                    rethrowAsLockException(e);
                }
            }
        }

        private void rethrowAsLockException(Exception e) {
            throw new CannotAcquireLockException("Failed to lock mutex at " + this.lockKey, e);
        }

        @Override
        public void lockInterruptibly() throws InterruptedException {
            this.localLock.lockInterruptibly();
            try {
                while (!obtainLock()) {
                    Thread.sleep(100); //NOSONAR
                }
            }
            catch (InterruptedException ie) {
                this.localLock.unlock();
                Thread.currentThread().interrupt();
                throw ie;
            }
            catch (Exception e) {
                this.localLock.unlock();
                rethrowAsLockException(e);
            }
        }

        @Override
        public boolean tryLock() {
            try {
                return tryLock(0, TimeUnit.MILLISECONDS);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            long now = System.currentTimeMillis();
            if (!this.localLock.tryLock(time, unit)) {
                return false;
            }
            try {
                long expire = now + TimeUnit.MILLISECONDS.convert(time, unit);
                boolean acquired;
                while (!(acquired = obtainLock()) && System.currentTimeMillis() < expire) { //NOSONAR
                    Thread.sleep(100); //NOSONAR
                }
                if (!acquired) {
                    this.localLock.unlock();
                }
                return acquired;
            }
            catch (Exception e) {
                this.localLock.unlock();
                rethrowAsLockException(e);
            }
            return false;
        }

        private boolean obtainLock() {
            boolean success = RedisLockRegistry.this.redisTemplate.execute(RedisLockRegistry.this.obtainLockScript,
                    Collections.singletonList(this.lockKey), RedisLockRegistry.this.clientId,
                    String.valueOf(RedisLockRegistry.this.expireAfter));
            if (success) {
                this.lockedAt = System.currentTimeMillis();
            }
            return success;
        }

        @Override
        public void unlock() {
            if (!this.localLock.isHeldByCurrentThread()) {
                throw new IllegalStateException("You do not own lock at " + this.lockKey);
            }
            if (this.localLock.getHoldCount() > 1) {
                this.localLock.unlock();
                return;
            }
            try {
                RedisLockRegistry.this.redisTemplate.delete(this.lockKey);
                if (logger.isDebugEnabled()) {
                    logger.debug("Released lock; " + this);
                }
            }
            finally {
                this.localLock.unlock();
            }
        }

        @Override
        public Condition newCondition() {
            throw new UnsupportedOperationException("Conditions are not supported");
        }

        public boolean isAcquiredInThisProcess() {
            return RedisLockRegistry.this.clientId.equals(
                    RedisLockRegistry.this.redisTemplate.boundValueOps(this.lockKey).get());
        }

        @Override
        public String toString() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd@HH:mm:ss.SSS");
            return "RedisLock [lockKey=" + this.lockKey
                    + ",lockedAt=" + dateFormat.format(new Date(this.lockedAt))
                    + ", clientId=" + RedisLockRegistry.this.clientId
                    + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((this.lockKey == null) ? 0 : this.lockKey.hashCode());
            result = prime * result + (int) (this.lockedAt ^ (this.lockedAt >>> 32));
            result = prime * result + RedisLockRegistry.this.clientId.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            RedisLock other = (RedisLock) obj;
            if (!getOuterType().equals(other.getOuterType())) {
                return false;
            }
            if (!this.lockKey.equals(other.lockKey)) {
                return false;
            }
            if (this.lockedAt != other.lockedAt) {
                return false;
            }
            return true;
        }

        private RedisLockRegistry getOuterType() {
            return RedisLockRegistry.this;
        }

    }

}
