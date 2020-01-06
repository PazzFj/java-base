package com.pazz.java.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: 彭坚
 * @create: 2018/12/17 22:39
 * @description:
 */
public class TestReadWriteLock {

    /*
     * 1. ReadWriteLock : 读写锁
     *
     * 写写/读写 需要“互斥”
     * 读读 不需要互斥
     */
    public static void main(String[] args) {
        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        new Thread(() -> rw.setNum((int) (Math.random() * 10)), "Write: ").start();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> rw.getNum(), "Read: " + i).start();
        }
    }


    static class ReadWriteLockDemo {
        private int num = 0;
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        public void getNum() {
            readWriteLock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " num: " + num);
            } finally {
                readWriteLock.readLock().unlock();
            }

        }

        public void setNum(int num) {
            readWriteLock.writeLock().lock();
            try {
                this.num = num;
                System.out.println(Thread.currentThread().getName());
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }
    }

}
