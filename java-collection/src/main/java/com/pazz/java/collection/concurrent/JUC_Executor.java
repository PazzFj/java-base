package com.pazz.java.collection.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author: 彭坚
 * @create: 2019/4/26 16:21
 * @description: Scheduled 安排, 预定
 */
public class JUC_Executor {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "MQClientFactoryScheduledThread");
            }
        });
        //安排固定速度
        /**
         * Runnable command,    //执行的线程对象
         * long initialDelay,   //延迟首次执行的时间
         * long period,         //连续执行之间的时间
         * TimeUnit uni         //初始时延和周期参数的时间单位
         *                          MILLISECONDS    表示千分之一秒的时间单位
         *                          MINUTES         表示六十秒的时间单位(分钟)
         */
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("come go1");
                } catch (Exception e) {

                }
            }
        }, 10, 1000 * 30, TimeUnit.MILLISECONDS);

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("come go2");
                } catch (Exception e) {

                }
            }
        }, 1000, 1000 * 30, TimeUnit.MILLISECONDS);

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("come go3");
                } catch (Exception e) {

                }
            }
        }, 1000 * 10, 1000 * 5, TimeUnit.MILLISECONDS);

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("come go4");
                } catch (Exception e) {

                }
            }
        }, 1, 1, TimeUnit.MINUTES);

    }

}
