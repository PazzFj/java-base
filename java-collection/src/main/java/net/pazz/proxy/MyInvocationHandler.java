package net.pazz.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: 彭坚
 * @create: 2018/8/30 9:47
 * @description:
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler() {
    }

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(object, args);
        after();
        return o;
    }

    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
