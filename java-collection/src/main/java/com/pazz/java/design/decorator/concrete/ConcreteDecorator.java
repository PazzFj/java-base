package com.pazz.java.design.decorator.concrete;

import com.pazz.java.design.decorator.Component;
import com.pazz.java.design.decorator.Decorator;

/**
 * @author: 彭坚
 * @create: 2018/12/24 17:33
 * @description: 装饰器模式：(具体装饰类)
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("修饰外表");
        super.operation();
    }
}
