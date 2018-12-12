package com.pazz.java.core.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: 彭坚
 * @create: 2018/12/12 17:25
 * @description:
 */
public class ExecutorTest {

    public static void main(String[] args) {
        //(创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。)
        ExecutorService es1 = Executors.newFixedThreadPool(10);
        //(创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。)
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        //(创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。)
        ExecutorService es3 = Executors.newCachedThreadPool();
        //(创建一个定长线程池，支持定时及周期性任务执行。)
        ExecutorService es4 = Executors.newScheduledThreadPool(5);
    }

}
