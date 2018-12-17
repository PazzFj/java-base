package com.pazz.java.core.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 彭坚
 * @create: 2018/12/17 20:50
 * @description:
 */
public class TestLock {

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
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(Thread.currentThread().getName() + " 完成售票, 余票为: " + --tick);
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
