package net.pazz.base;

import net.pazz.base.thread.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMain {

    public static void main(String[] args) {

        //单个线程的线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();
        //固定数量的线程池
        ExecutorService pool2 = Executors.newFixedThreadPool(4);
        //创建一个可缓存线程池
        ExecutorService pool3 =  Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++){
//            MyThread myThread = new MyThread();
//            pool2.execute(myThread);
            MyRunnable myRunnable = new MyRunnable("peng", "jian");
            pool2.execute(myRunnable);
        }
        pool2.shutdown();

    }

}
