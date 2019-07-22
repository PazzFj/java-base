package net.pazz.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: 彭坚
 * @create: 2018/8/29 17:01
 * @description: 动态代理
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        SecurityManager securityManager = System.getSecurityManager();
        System.out.println(Thread.currentThread().getThreadGroup().toString());
        System.out.println();
        SubDynamicBean subDynamicBean = new DynamicBean("proxyName");
        InvokeHandler handler = new InvokeHandler(subDynamicBean);
        Object obj = Proxy.newProxyInstance(SubDynamicBean.class.getClassLoader(), subDynamicBean.getClass().getInterfaces(), handler);
        ((SubDynamicBean) obj).testName();
    }

    static class InvokeHandler implements InvocationHandler {

        private Object proxy;

        public InvokeHandler(Object proxy) {
            this.proxy = proxy;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(this.proxy, args);
        }
    }

}
