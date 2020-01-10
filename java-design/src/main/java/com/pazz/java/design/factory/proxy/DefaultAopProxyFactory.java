package com.pazz.java.design.factory.proxy;

/**
 * @author: 彭坚
 * @create: 2019/8/16 17:00
 * @description: 默认aop代理工厂实现
 */
public class DefaultAopProxyFactory extends AbstractAopProxyFactory {

    @Override
    public AopProxy getAopProxy(Object target) {
        if (target instanceof String) {
            if ("jdk".equals(target)) {
                return new AopProxyJdkDynamicImpl();
            } else
                return new AopProxyCglibImpl();
        }
        return new AopProxyJdkDynamicImpl();
    }

}
