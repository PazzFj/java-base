package net.pazz.base.thread;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行中。。。");
    }

}
