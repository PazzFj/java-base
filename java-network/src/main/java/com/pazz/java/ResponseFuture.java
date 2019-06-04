package com.pazz.java;

/**
 * @author: 彭坚
 * @create: 2019/5/24 11:08
 * @description:
 */
public class ResponseFuture {

    private InvokeCallback callback;

    private String name;

    public ResponseFuture(InvokeCallback callback, String name) {
        this.callback = callback;
        this.name = name;
    }

    public InvokeCallback getCallback() {
        return callback;
    }

    public void setCallback(InvokeCallback callback) {
        this.callback = callback;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void executeInvokeCallback(){
        callback.operationComplete(this);
    }
}
