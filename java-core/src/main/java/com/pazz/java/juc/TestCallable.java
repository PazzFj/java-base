package com.pazz.java.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: 彭坚
 * @create: 2018/12/17 20:30
 * @description:
 */
public class TestCallable {

    /**
     * 一、创建执行线程的方式三：实现 Callable 接口。 相较于实现 Runnable 接口的方式，方法可以有返回值，并且可以抛出异常。
     *
     * 二、执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。  FutureTask 是  Future 接口的实现类
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        @SuppressWarnings("unchecked")
        ThreadDemo td = new ThreadDemo();
        @SuppressWarnings("unchecked")
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
