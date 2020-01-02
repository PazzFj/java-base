package com.pazz.java.design.spring_aop_factory;

/**
 * @author: 彭坚
 * @create: 2019/8/16 17:03
 * @description:
 */
public class CglibAopProxy implements AopProxy {
    @Override
    public void getProxy(Object target) {
        System.out.println("cglib proxy " + target);
    }
}
