package net.pazz.yto.lock;

/**
 * @author: Peng Jian
 * @date: 2018/6/15 11:08
 * @description: 实现此接口 {@link LockRegister}  的支持删除当前未锁的旧锁。
 */
public interface ExpirableLockRegistry extends LockRegister {

    /**
     * 本地锁超时时间
     * 默认1小时
     */
    long DEFAULT_EXPIRE_UNUSED_OLDER_THEN_TIME = 1000 * 60 * 60;

    /**
     * 获取默认本地锁超时失效时间
     * @return
     */
    default long getDefaultExpireUnusedOlderThanTime(){
        return DEFAULT_EXPIRE_UNUSED_OLDER_THEN_TIME;
    }

    /**
     * 删除当前未锁的最近获得的锁。
     * @param age 锁最后得到的时间。
     * @throws IllegalStateException if the registry configuration does not support this feature.
     */
    void expireUnusedOlderThan(long age);

}
