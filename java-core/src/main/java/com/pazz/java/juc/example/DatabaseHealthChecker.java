package com.pazz.java.juc.example;

import java.util.concurrent.CountDownLatch;

/**
 * @author: 彭坚
 * @create: 2018/12/18 9:54
 * @description: 数据库健康检查
 */
public class DatabaseHealthChecker extends BaseHealthChecker {
    public DatabaseHealthChecker(CountDownLatch countDownLatch) {
        super("Database Service", countDownLatch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
