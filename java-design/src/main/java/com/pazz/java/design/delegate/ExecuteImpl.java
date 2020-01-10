package com.pazz.java.design.delegate;

/**
 * @author: Peng Jian
 * @create: 2018/9/29 14:19
 * @description: 委派员工
 */
public class ExecuteImpl implements Delegate {

    @Override
    public void doWork() {
        System.out.println("ExectorA 开始干活了");
    }

}
