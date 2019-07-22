package com.pazz.java.test.thread;

/**
 * @author: 彭坚
 * @create: 2019/3/5 23:23
 * @description:
 */
public class MainTest {

    public static void main(String[] args) {
        ThreadLocal<Object> local = new ThreadLocal<>();
        local.set("aaaaaaaaa");

        System.out.println((String) local.get());
    }

}
