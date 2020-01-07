package com.pazz.java.thinking.rocketmq;

/**
 * @author: 彭坚
 * @create: 2019/5/24 11:07
 * @description:
 */
public interface InvokeCallback {

    void operationComplete(final ResponseFuture responseFuture);

}
