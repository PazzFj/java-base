package com.pazz.java.juc.example;

import java.util.concurrent.CountDownLatch;

/**
 * @author: 彭坚
 * @create: 2018/12/18 9:53
 * @description: 缓存健康检查
 */
public class CacheHealthChecker extends BaseHealthChecker {

    public CacheHealthChecker(CountDownLatch countDownLatch) {
        super("Cache Service", countDownLatch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
