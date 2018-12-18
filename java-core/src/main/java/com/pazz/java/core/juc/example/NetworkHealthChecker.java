package com.pazz.java.core.juc.example;

import java.util.concurrent.CountDownLatch;

/**
 * @author: 彭坚
 * @create: 2018/12/18 9:50
 * @description:
 */
public class NetworkHealthChecker extends BaseHealthChecker {

    public NetworkHealthChecker(CountDownLatch countDownLatch) {
        super("Network Service", countDownLatch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
