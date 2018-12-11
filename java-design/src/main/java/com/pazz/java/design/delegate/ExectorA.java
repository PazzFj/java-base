package com.pazz.java.design.delegate;

/**
 * @author: Peng Jian
 * @create: 2018/9/29 14:19
 * @description: 委派员工
 */
public class ExectorA implements Delegate {

    @Override
    public void doWork() {
        System.out.println("A 开始干活了");
    }

}
