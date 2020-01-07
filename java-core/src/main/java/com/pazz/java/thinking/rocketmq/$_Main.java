package com.pazz.java.thinking.rocketmq;

/**
 * @author: 彭坚
 * @create: 2019/5/24 15:11
 * @description:
 */
public class $_Main {

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.send("sss", responseFuture -> System.out.println(responseFuture.getName()));
    }

}
