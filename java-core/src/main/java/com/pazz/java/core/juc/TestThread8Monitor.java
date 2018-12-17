package com.pazz.java.core.juc;

/**
 * @author: 彭坚
 * @create: 2018/12/17 23:09
 * @description:
 */
public class TestThread8Monitor {

    public static void main(String[] args) {
        Number number1 = new Number();
        Number number2 = new Number();

        new Thread(() -> number1.getOne()).start();

        new Thread(() -> number2.getTwo()).start();

    }

    static class Number {

        public synchronized void getOne() {  // this
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("one");
        }

        public static synchronized void getTwo() {  //static synchronized  Number.class
            System.out.println("two");
        }
    }

}
