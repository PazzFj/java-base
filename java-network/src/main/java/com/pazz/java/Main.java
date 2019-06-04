package com.pazz.java;

/**
 * @author: 彭坚
 * @create: 2019/5/24 15:11
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.send("sss", new InvokeCallback() {
            @Override
            public void operationComplete(ResponseFuture responseFuture) {
                System.out.println(responseFuture.getName());
            }
        });
    }

}
