package com.pazz.java.core.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: 彭坚
 * @create: 2018/12/17 20:30
 * @description:
 */
public class TestCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadDemo td = new ThreadDemo();
        FutureTask<Integer> future = new FutureTask(td);

        new Thread(future).start();

        int sum = future.get();

        System.out.println(sum);
        System.out.println("------------------");

    }

    static class ThreadDemo implements Callable<Integer> {

        @Override
        public Integer call() {
            int sum = 0;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sum += i;
            }
            return sum;
        }

    }

}
