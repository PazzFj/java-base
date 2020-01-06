package com.pazz.java.juc.example;

import java.util.concurrent.CountDownLatch;

/**
 * @author: 彭坚
 * @create: 2018/12/18 9:46
 * @description: 基础健康检查
 */
public abstract class BaseHealthChecker implements Runnable {

    private CountDownLatch countDownLatch;
    private String serviceName;
    private boolean serviceUp;

    public BaseHealthChecker(String serviceName, CountDownLatch countDownLatch){
        this.serviceName = serviceName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            verifyService();
            serviceUp = true;
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            serviceUp = false;
        } finally {
            if(countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    //此方法需要由所有特定的服务检查器实现
    public abstract void verifyService();

    public String getServiceName() {
        return serviceName;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }
}
