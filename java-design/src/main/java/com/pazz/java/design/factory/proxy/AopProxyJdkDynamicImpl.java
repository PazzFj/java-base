package com.pazz.java.design.factory.proxy;

/**
 * @author: 彭坚
 * @create: 2019/8/16 17:01
 * @description: jdk 动态代理
 */
public class AopProxyJdkDynamicImpl implements AopProxy {

    @Override
    public Object createProxy(Object target) {
        System.out.println("jdk dynamic 已经代理 " + target);
        return target;
    }

}
