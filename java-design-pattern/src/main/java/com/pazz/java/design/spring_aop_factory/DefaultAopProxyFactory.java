package com.pazz.java.design.spring_aop_factory;

/**
 * @author: 彭坚
 * @create: 2019/8/16 17:00
 * @description:
 */
public class DefaultAopProxyFactory extends AbstractAopProxyFactory {
    @Override
    public AopProxy getProxy(Object target) {
        if(target instanceof  String){
            if(((String)target).equals("jdk")){
                return new JdkDyncamicAopProxy();
            }else
                return new CglibAopProxy();
        }
        return new JdkDyncamicAopProxy();
    }
}
