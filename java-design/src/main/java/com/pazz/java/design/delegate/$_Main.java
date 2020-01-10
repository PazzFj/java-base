package com.pazz.java.design.delegate;

/**
 * @author: Peng Jian
 * @create: 2020/1/2 17:17
 * @description: delegate 委派模式
 */
public class $_Main {
    public static void main(String[] args) {
        //delegate 委派模式=代理模式
        Delegate delegate = new ExecuteImpl();
        ExecuteManager executeManager = new ExecuteManager(delegate);
        executeManager.doWork();
    }
}
