package net.pazz.yto.lock;

import java.util.concurrent.locks.Lock;

/**
 * @author: Peng Jian
 * @date: 2018/6/15 9:37
 * @description: 维护共享锁的注册表的策略。
 */
@FunctionalInterface
public interface LockRegister {

    /**
     * 获取与参数对象关联的锁。
     * @param lockKey 锁相关联的对象。
     * @return 相关的锁。
     */
    Lock obtain(Object lockKey);

}
