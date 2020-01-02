package com.pazz.java.design.spring_aop_factory;

/**
 * @author: 彭坚
 * @create: 2019/8/16 16:57
 * @description:
 */
public class ProxyFactory {

    private static AbstractAopProxyFactory aopProxyFactory = new DefaultAopProxyFactory();

    public static AopProxy getProxy(Object target){
        return aopProxyFactory.getProxy(target);
    }

    public static void main(String[] args) {
        AopProxy aopProxy = getProxy("cglib");
        aopProxy.getProxy("Proxy");
    }

}
