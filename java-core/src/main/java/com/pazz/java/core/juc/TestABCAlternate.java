package com.pazz.java.core.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 彭坚
 * @create: 2018/12/17 22:12
 * @description:
 */
public class TestABCAlternate {

    public static void main(String[] args) {
        AlternateDemo ad = new AlternateDemo();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                ad.loopA(i);
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                ad.loopB(i);
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                ad.loopC(i);
            }
        }, "C").start();


    }


    static class AlternateDemo {

        private int num = 1;//标记

        private Lock lock = new ReentrantLock();
        private Condition condition1 = lock.newCondition();
        private Condition condition2 = lock.newCondition();
        private Condition condition3 = lock.newCondition();

        public void loopA(int totalLoop) {
            lock.lock();
            try {
                if (num != 1) {
                    condition1.await();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + totalLoop);
                num = 2;
                condition2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void loopB(int totalLoop) {
            lock.lock();
            try {
                if (num != 2) {
                    condition2.await();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + totalLoop);
                num = 3;
                condition3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void loopC(int totalLoop) {
            lock.lock();
            try {
                if (num != 3) {
                    condition3.await();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + totalLoop);
                num = 1;
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }


    }
}
