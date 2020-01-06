package com.pazz.java.juc;

/**
 * @author: 彭坚
 * @create: 2019/1/10 15:37
 * @description:
 */
public class TestYZX {

    public static void main(String[] args) {
        int a = 1;
        ThreadDemo thread = new ThreadDemo(a);
        for (int i = 0; i < 100; i++) {
            new Thread(thread).start();
            new Thread(thread).start();
        }
    }

    static class ThreadDemo implements Runnable {
        int i;

        public ThreadDemo(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("i++ = " + i++);
        }
    }

    static class ThreadDemo2 extends Thread {
        int i;

        public ThreadDemo2(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            i = i + 1;
            System.out.println("i = i+1 " + i);
        }
    }

}
