package net.pazz.base.thread;

/**
* @description: 实现Runnable
* @author: Peng Jian
* @date: 2018/5/31 14:29
*/
public class MyRunnable implements Runnable {

    private String name;
    private String code;

    public MyRunnable(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public void run() {
        System.out.println("currentThreadName: " + Thread.currentThread().getName() + " name: " + name + " code: " + code + "  执行中~~~");
    }

}
