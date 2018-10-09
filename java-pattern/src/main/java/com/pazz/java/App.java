package com.pazz.java;

import com.pazz.java.delegate.Delegate;
import com.pazz.java.delegate.ExectorA;
import com.pazz.java.delegate.ExectorManager;
import com.pazz.java.prototype.Shape;
import com.pazz.java.prototype.ShapeCache;
import com.pazz.java.proxy.CglibProxyFactory;
import com.pazz.java.proxy.ISinger;
import com.pazz.java.proxy.Singer;
import com.pazz.java.proxy.SingerStaticProxy;
import com.pazz.java.template.AbstractTemplate;
import com.pazz.java.template.TemplateTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * delegate 委派模式
 * factory 工厂模式
 * prototype 原型模式
 * proxy 代理模式
 * singleton 单例模式
 * strategy 策略模式
 * template 模板模式
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        //delegate
        Delegate delegate = new ExectorA();
        ExectorManager exectorManager = new ExectorManager(delegate) ;
        exectorManager.doWork();

        //prototype  -------->> Object.clone();
        ShapeCache.loadCache();
        Shape shape = ShapeCache.getShape("2");
        System.out.println(shape);

        /**
         *         // 总结：其实这里做的事情无非就是，创建一个代理类SingerProxy，继承了ISinger接口并实现了其中的方法。只不过这种实现特意包含了目标对象的方法，
         *         // 正是这种特征使得看起来像是“扩展”了目标对象的方法。假使代理对象中只是简单地对sing方法做了另一种实现而没有包含目标对象的方法，
         *         // 也就不能算作代理模式了。所以这里的包含是关键。
         *         // 缺点：这种实现方式很直观也很简单，但其缺点是代理对象必须提前写出，如果接口层发生了变化，代理对象的代码也要进行维护。
         *         // 如果能在运行时动态地写出代理对象，不但减少了一大批代理类的代码，也少了不断维护的烦恼，不过运行时的效率必定受到影响。
         */
        //proxy（Static Proxy）
        ISinger singer = new Singer();
        ISinger proxy = new SingerStaticProxy(singer);
        proxy.sing();

        //proxy (Dynamic Proxy)
        ISinger dynamicProxy = (ISinger) Proxy.newProxyInstance(singer.getClass().getClassLoader(), singer.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Dynamic 向观众问好");
                method.invoke(singer, args);
                System.out.println("Dynamic 谢谢大家");
                return null;
            }
        });
        dynamicProxy.sing();

        /**
         *         //在Spring的AOP编程中：
         *         //如果加入容器的目标对象有实现接口，用JDK代理
         *         //如果目标对象没有实现接口，用Cglib代理
         */
        // Cglib
        Singer proxyFactory = (Singer) new CglibProxyFactory(singer).getProxyInstance();
        proxyFactory.sing();

        //Template
        AbstractTemplate at = new TemplateTest();
        at.temp();


    }
}
