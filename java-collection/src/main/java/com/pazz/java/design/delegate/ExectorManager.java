package com.pazz.java.design.delegate;

/**
 * @author: Peng Jian
 * @create: 2018/9/29 14:20
 * @description: 委派经理
 */
public class ExectorManager implements Delegate {

    private Delegate delegate;

    public ExectorManager(Delegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void doWork() {
        delegate.doWork();
    }
}
