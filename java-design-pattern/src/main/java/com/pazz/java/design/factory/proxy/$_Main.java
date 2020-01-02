package com.pazz.java.design.factory.proxy;

/**
 * @author: 彭坚
 * @create: 2019/8/16 16:57
 * @description: 工厂代理
 */
public class $_Main {

    public static void main(String[] args) {
        AbstractAopProxyFactory aopProxyFactory = new DefaultAopProxyFactory();
        AopProxy aopProxy = aopProxyFactory.getAopProxy("cglib");
        aopProxy.createProxy("目标对象");
    }

}
