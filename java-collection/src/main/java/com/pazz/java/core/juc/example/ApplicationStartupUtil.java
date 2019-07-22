package com.pazz.java.core.juc.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: 彭坚
 * @create: 2018/12/18 9:51
 * @description:
 */
public class ApplicationStartupUtil {

    //List of service checkers
    private static List<BaseHealthChecker> services;

    //This latch will be used to wait on
    private static CountDownLatch countDownLatch;

    private ApplicationStartupUtil() {
    }

    private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance() {
        return INSTANCE;
    }

    //检测外部服务
    public static boolean checkExternalServices() throws Exception {
        //Initialize the latch with number of service checkers
        countDownLatch = new CountDownLatch(3);

        //All add checker in lists
        services = new ArrayList<>();
        services.add(new NetworkHealthChecker(countDownLatch));
        services.add(new CacheHealthChecker(countDownLatch));
        services.add(new DatabaseHealthChecker(countDownLatch));

        //Start service checkers using executor framework
        Executor executor = Executors.newFixedThreadPool(services.size());

        for (final BaseHealthChecker v : services) {
            executor.execute(v);
        }

        //Now wait till all services are checked
        countDownLatch.await();

        //Services are file and now proceed startup
        for (final BaseHealthChecker v : services) {
            if (!v.isServiceUp()) {
                return false;
            }
        }
        ((ExecutorService) executor).shutdown();
        return true;
    }

}
