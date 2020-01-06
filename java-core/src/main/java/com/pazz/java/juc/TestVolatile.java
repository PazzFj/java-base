package com.pazz.java.juc;

import java.util.concurrent.locks.ReentrantLock;

/*
 * 一、volatile 关键字：当多个线程进行操作共享数据时，可以保证内存中的数据可见。
 * 					  相较于 synchronized 是一种较为轻量级的同步策略。
 *
 * 注意：
 * 1. volatile 不具备“互斥性”
 * 2. volatile 不能保证变量的“原子性”
 */
public class TestVolatile {

    public static void main(String[] args) {
//        ThreadDemo td = new ThreadDemo();
//        new Thread(td).start();
//
//        while (true) {
//            if (td.isFlag()) {
//                System.out.println("------------------");
//                break;
//            }
//        }
        Object o = new Object();
        ThreadVolatile threadVolatile = new ThreadVolatile(o);
        for (int i = 0; i < 10; i++) {
            new Thread(threadVolatile).start();
        }

    }

    static class ThreadVolatile implements Runnable {
        private int serialNumber = 0;

        private ReentrantLock lock = new ReentrantLock();
        private Object object = null;

        public ThreadVolatile(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                Thread.sleep(200);
                serialNumber = serialNumber + 1;
                System.out.println(serialNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    static class ThreadDemo implements Runnable {

        private volatile boolean flag = false;

        @Override
        public void run() {

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }

            flag = true;

            System.out.println("flag=" + isFlag());

        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

    }

}

