package com.pazz.java.thinking.rocketmq;

/**
 * @author: 彭坚
 * @create: 2019/5/24 14:57
 * @description:
 */
public class ProducerImpl {

    public SendResult send(String str, InvokeCallback callback){
        System.out.println(str);
        ResponseFuture responseFuture = new ResponseFuture(callback, "invoke");
        responseFuture.executeInvokeCallback();
        return new SendResult("ok");
    }

}
