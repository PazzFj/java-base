package com.pazz.java.core.juc;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: 彭坚
 * @create: 2018/12/16 17:55
 * @description:
 */
public class TestVolatile {

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        new Thread(demo).start();
        while (true) {
            if (demo.getAtomicBoolean().get()) {
                System.out.println("-----------");
                break;
            }
        }
    }

    static class ThreadDemo implements Runnable {

        private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        @Override
        public void run() {
            try {
                Thread.sleep(200);
                atomicBoolean.set(true);
                System.out.println("flag: " + atomicBoolean.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public AtomicBoolean getAtomicBoolean() {
            return atomicBoolean;
        }

        public void setAtomicBoolean(AtomicBoolean atomicBoolean) {
            this.atomicBoolean = atomicBoolean;
        }
    }

}
