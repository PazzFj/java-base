package com.pazz.java.network;

/**
 * @author: 彭坚
 * @create: 2019/5/24 14:51
 * @description:
 */
public class Producer {

    private ProducerImpl producer = new ProducerImpl();

    public void send (String str, InvokeCallback callback){
        SendResult result = producer.send(str, callback);
        System.out.println("result: " + result.getResult());
    }

}
