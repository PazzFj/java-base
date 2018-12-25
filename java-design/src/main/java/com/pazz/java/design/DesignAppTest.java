package com.pazz.java.design;

import com.pazz.java.design.adapter.Adapter;
import com.pazz.java.design.adapter.Target;
import com.pazz.java.design.builder.BikeBuilder;
import com.pazz.java.design.builder.EngineeringDepartment;
import com.pazz.java.design.builder.MoBikeBuilder;
import com.pazz.java.design.builder.OfoBikeBuilder;
import com.pazz.java.design.decorator.Component;
import com.pazz.java.design.decorator.concrete.ConcreteComponent;
import com.pazz.java.design.decorator.concrete.ConcreteDecorator;
import com.pazz.java.design.decorator.concrete.ConcreteDecorator2;
import com.pazz.java.design.decorator.concrete.ConcreteDecorator3;
import com.pazz.java.design.delegate.Delegate;
import com.pazz.java.design.delegate.ExectorA;
import com.pazz.java.design.delegate.ExectorManager;
import com.pazz.java.design.prototype.Shape;
import com.pazz.java.design.prototype.ShapeCache;
import com.pazz.java.design.proxy.CglibProxyFactory;
import com.pazz.java.design.proxy.ISinger;
import com.pazz.java.design.singleton.SingletonA;
import com.pazz.java.design.singleton.SingletonB;
import com.pazz.java.design.singleton.SingletonC;
import com.pazz.java.design.template.AbstractTemplate;
import com.pazz.java.design.template.TemplateTest;
import com.pazz.java.design.proxy.Singer;
import com.pazz.java.design.proxy.SingerStaticProxy;

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
public class DesignAppTest
{
    public static void main( String[] args ) throws Exception
    {
        //delegate 委派模式=代理模式
        Delegate delegate = new ExectorA();
        ExectorManager exectorManager = new ExectorManager(delegate) ;
        exectorManager.doWork();

        //prototype  -------->> Object.clone(); 克隆
        ShapeCache.loadCache(); //加载数据
        Shape shape = ShapeCache.getShape("2");
        System.out.println(shape);

        /**
         *         // 总结：其实这里做的事情无非就是，创建一个代理类SingerProxy，继承了ISinger接口并实现了其中的方法。只不过这种实现特意包含了目标对象的方法，
         *         // 正是这种特征使得看起来像是“扩展”了目标对象的方法。假使代理对象中只是简单地对sing方法做了另一种实现而没有包含目标对象的方法，
         *         // 也就不能算作代理模式了。所以这里的包含是关键。
         *         // 缺点：这种实现方式很直观也很简单，但其缺点是代理对象必须提前写出，如果接口层发生了变化，代理对象的代码也要进行维护。
         *         // 如果能在运行时动态地写出代理对象，不但减少了一大批代理类的代码，也少了不断维护的烦恼，不过运行时的效率必定受到影响。
         *
         *          //在Spring的AOP编程中：
         *          //如果加入容器的目标对象有实现接口，用JDK代理
         *          //如果目标对象没有实现接口，用Cglib代理
         */
        //静态代理（Static Proxy）
        ISinger singer = new Singer();
        ISinger staticProxy = new SingerStaticProxy(singer);
        staticProxy.sing();
        //动态代理 (Dynamic Proxy)      InvocationHandler
        ISinger dynamicProxy = (ISinger) Proxy.newProxyInstance(singer.getClass().getClassLoader(), singer.getClass().getInterfaces(), (o, m, p) -> {
            System.out.println("Dynamic 向观众问好");
            m.invoke(singer, p);
            System.out.println("Dynamic 谢谢大家");
            return null;
        });
        dynamicProxy.sing();
        // Cglib  基于拦截
        Singer proxyFactory = (Singer) new CglibProxyFactory(singer).getProxyInstance();
        proxyFactory.sing();

        //Template
        AbstractTemplate at = new TemplateTest();
        at.temp();

        //Singleton  =================== volatile 内存可见性
        SingletonA singletonA1 = SingletonA.getInstance();
        System.out.println(singletonA1 + "___" + SingletonA.getInstance());

        SingletonB singletonB1 = SingletonB.getInstance();
        System.out.println(singletonB1 + "___" + SingletonB.getInstance());

        SingletonC singletonC1 = SingletonC.initialInstance();
        System.out.println(singletonC1 + "___" + SingletonC.initialInstance());

        /**************************装饰器模式******************************/
        System.out.println("****************装饰器模式***************");
        Component component = new ConcreteComponent();//具体组件
        Component component1 = new ConcreteDecorator(component);
        Component component2 = new ConcreteDecorator2(component1);
        Component component3 = new ConcreteDecorator3(component2);
//        component1.operation();
//        component2.operation();
        component3.operation();

        /**************************适配器模式******************************/
        System.out.println("****************适配器模式***************");
        Target target = new Adapter();
        target.request();

        /**************************建造者模式******************************/
        System.out.println("****************建造者模式***************");
        BikeBuilder builder1 = new MoBikeBuilder();
        BikeBuilder builder2 = new OfoBikeBuilder();
        EngineeringDepartment department = new EngineeringDepartment(builder2);
        department.construct();
        System.out.println(builder2.getBike());

    }
}
