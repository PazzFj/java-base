package com.pazz.java.core.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: 彭坚
 * @create: 2019/7/17 23:31
 * @description:
 */
public class TestExecutorService {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(1, 10, 5L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 start");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 start");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("t3 start");
            }
        });

        executorService.shutdown();
    }

}
