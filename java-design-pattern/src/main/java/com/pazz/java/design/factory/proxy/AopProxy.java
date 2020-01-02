package com.pazz.java.design.factory.proxy;

/**
 * @author: 彭坚
 * @create: 2019/8/16 17:00
 * @description:
 */
public interface AopProxy {

    /**
     * 创建代理
     */
    Object createProxy(Object target);

}
