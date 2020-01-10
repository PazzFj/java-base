package com.pazz.java.design.proxy;

import java.lang.reflect.Proxy;

/**
 * @author: Peng Jian
 * @create: 2020/1/2 20:55
 * @description: 代理模式
 */
public class $_Main {
    public static void main(String[] args) {
        /*
            总结：其实这里做的事情无非就是，创建一个代理类SingerProxy，继承了Singer接口并实现了其中的方法。
                     只不过这种实现特意包含了目标对象的方法， 正是这种特征使得看起来像是“扩展”了目标对象的方法。
                     假使代理对象中只是简单地对sing方法做了另一种实现而没有包含目标对象的方法，也就不能算作代理模式了。
                     所以这里的包含是关键。
                缺点：这种实现方式很直观也很简单，但其缺点是代理对象必须提前写出，如果接口层发生了变化，代理对象的代码也要进行维护。
                     如果能在运行时动态地写出代理对象，不但减少了一大批代理类的代码，也少了不断维护的烦恼，不过运行时的效率必定受到影响。

                在Spring的AOP编程中：
                     如果加入容器的目标对象有实现接口，用JDK动态代理
                     如果目标对象没有实现接口，用Cglib代理
         */
        //静态代理（Static Proxy）
        Singer singer = new SingerImpl();
        Singer staticProxy = new SingerStaticProxy(singer);
//        staticProxy.sing();
        System.out.println(staticProxy);
        //动态代理 (Dynamic Proxy)
        Singer dynamicProxy = (Singer) Proxy.newProxyInstance(singer.getClass().getClassLoader(), singer.getClass().getInterfaces(), (o, m, p) -> {
            System.out.println("Dynamic 向观众问好");
            m.invoke(singer, p);
            System.out.println("Dynamic 谢谢大家");
            return null;
        });
        System.out.println(dynamicProxy);
//        dynamicProxy.sing();
    }
}
