package net.pazz.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Peng Jian
 * @create: 2018/10/18 10:52
 * @description:
 */
public class TestExecutor {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("ssssssssssssss");
            }
        });
        service.shutdown();
    }

}
