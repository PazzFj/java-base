package com.pazz.java.core.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: 彭坚
 * @create: 2018/12/12 17:25
 * @description:
 */
public class ExecutorTest {

    public static void main(String[] args) {
        //(创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。)
        ExecutorService es1 = Executors.newFixedThreadPool(5);
        //(创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。)
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        //(创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。)
        ExecutorService es3 = Executors.newCachedThreadPool();
        //(创建一个定长线程池，支持定时及周期性任务执行。)
        ScheduledExecutorService es4 = Executors.newScheduledThreadPool(5);

        es1.submit(new Task("name1"));
        es1.submit(new Task("name2"));
        es1.submit(new Task("name3"));
        es2.submit(new Task("single1"));
        es2.submit(new Task("single2"));
        es2.submit(new Task("single3"));
        es3.submit(new Task("cache1"));
        es3.submit(new Task("cache2"));
        es3.submit(new Task("cache3"));
        //schedule定时走的线程
        es4.schedule(new Task("pengjian1"), 7, TimeUnit.SECONDS);
        es4.schedule(new Task("pengjian2"), 5, TimeUnit.SECONDS);
        es4.schedule(new Task("pengjian3"), 10, TimeUnit.SECONDS);


        es1.shutdown();
        es2.shutdown();
        es3.shutdown();
        es4.shutdown();
    }

    static class Task implements Runnable {

        private String name;

        public Task(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("my Task..." + this.name);
        }
    }

}
