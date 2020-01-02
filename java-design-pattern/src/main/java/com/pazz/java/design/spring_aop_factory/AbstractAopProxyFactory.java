package com.pazz.java.design.spring_aop_factory;

/**
 * @author: 彭坚
 * @create: 2019/8/16 16:58
 * @description:
 */
public abstract class AbstractAopProxyFactory {

    abstract AopProxy getProxy(Object target);

}
