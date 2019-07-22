package com.pazz.java.core.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 彭坚
 * @create: 2018/12/17 20:50
 * @description:
 */
public class TestLock {

    /*
     * 一、用于解决多线程安全问题的方式：
     *
     * synchronized:隐式锁
     * 1. 同步代码块
     *
     * 2. 同步方法
     *
     * jdk 1.5 后：
     * 3. 同步锁 Lock
     * 注意：是一个显示锁，需要通过 lock() 方法上锁，必须通过 unlock() 方法进行释放锁
     */
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "窗口1").start();
        new Thread(ticket, "窗口2").start();
        new Thread(ticket, "窗口3").start();
    }

    static class Ticket implements Runnable {

        private Lock lock = new ReentrantLock();

        private int tick = 100;

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (tick > 0) {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + " 完成售票, 余票为: " + --tick);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
