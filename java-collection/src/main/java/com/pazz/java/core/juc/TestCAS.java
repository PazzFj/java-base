package com.pazz.java.core.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: 彭坚
 * @create: 2019/1/10 16:01
 * @description:
 */
public class TestCAS {

    private static volatile int number = 0;
    //    private static AtomicInteger number = new AtomicInteger(0);

    public static synchronized int getNumber() {
//        return number.getAndIncrement();
        return number++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        getNumber();
                    }
                }
            }).start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(number);
    }


}
