package com.pazz.java.design.spring_aop_factory;

/**
 * @author: 彭坚
 * @create: 2019/8/16 17:01
 * @description:
 */
public class JdkDyncamicAopProxy implements AopProxy {
    @Override
    public void getProxy(Object target) {
        System.out.println("jdk dynamic proxy" + target);
    }
}
