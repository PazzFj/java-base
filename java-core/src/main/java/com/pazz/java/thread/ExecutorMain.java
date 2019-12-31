package com.pazz.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorMain {

    public static void main(String[] args) {
        //创建一个固定长度的线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        threadPool1.submit(() -> {
            System.out.println("submit run...");
        });
        threadPool1.execute(() -> {
            System.out.println("execute run...");
        });

        //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        ExecutorService threadPoll2 = Executors.newSingleThreadExecutor();

        //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
        ExecutorService threadPool3 = Executors.newCachedThreadPool();

        //创建一个定长线程池，支持定时及周期性任务执行。
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(() -> {
            System.out.println("schedule run...");
        }, 5, TimeUnit.SECONDS);

        threadPool1.shutdown();
        threadPoll2.shutdown();
        threadPool3.shutdown();
        scheduledThreadPool.shutdown();
    }

}
