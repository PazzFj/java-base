package com.pazz.java.design;

import com.pazz.java.design.abstractFactory.AbstractFactory;
import com.pazz.java.design.abstractFactory.FactoryProducer;
import com.pazz.java.design.prototype.Shape;
import com.pazz.java.design.proxy.Singer;
import com.pazz.java.design.proxy.SingerImpl;
import com.pazz.java.design.proxy.SingerStaticProxy;
import com.pazz.java.design.singleton.SingletonA;
import com.pazz.java.design.singleton.SingletonB;
import com.pazz.java.design.singleton.SingletonC;
import com.pazz.java.design.template.AbstractTemplate;
import com.pazz.java.design.template.TemplateTest;
import com.pazz.java.design.visitor.ComputerPartDisplayVisitor;
import com.pazz.java.design.visitor.part.Computer;

import java.lang.reflect.Proxy;

/**
 * abstractFactory 抽象工厂
 * adapter 适配器模式
 * builder 建造者模式
 * composite 组合模式
 * delegate 委派模式
 * spring_aop_factory 工厂模式
 * prototype 原型模式
 * proxy 代理模式
 * singleton 单例模式
 * strategy 策略模式
 * template 模板模式
 */
public class DesignAppTest {
    public static void main(String[] args) throws Exception {

        //获取形状工厂
        AbstractFactory<Shape> shapeFactory = FactoryProducer.getFactory("SHAPE");
        //获取形状为 Circle 的对象
        Shape shape1 = shapeFactory.get("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();

        // 适配器模式
        Computer computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());








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

        /**************************适配器模式******************************/

        /**************************建造者模式******************************/

        /**************************组合模式******************************/

        /**************************策略模式******************************/
    }



}
