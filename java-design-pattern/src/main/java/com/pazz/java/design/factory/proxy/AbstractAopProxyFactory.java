package com.pazz.java.design.factory.proxy;

/**
 * @author: 彭坚
 * @create: 2019/8/16 16:58
 * @description: aop代理工厂, 用于创建AopProxy
 */
public abstract class AbstractAopProxyFactory {

    /**
     * 获取 AopProxy
     */
    abstract AopProxy getAopProxy(Object target);

}
