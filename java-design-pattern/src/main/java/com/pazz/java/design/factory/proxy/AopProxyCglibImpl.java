package com.pazz.java.design.factory.proxy;

/**
 * @author: 彭坚
 * @create: 2019/8/16 17:03
 * @description: cglib代理
 */
public class AopProxyCglibImpl implements AopProxy {

    @Override
    public Object createProxy(Object target) {
        System.out.println("cglib 已经代理 " + target);
        return target;
    }

}
