package com.pazz.java.design.decorator.concrete;

import com.pazz.java.design.decorator.Component;
import com.pazz.java.design.decorator.Decorator;

/**
 * @author: 彭坚
 * @create: 2018/12/25 9:05
 * @description:
 */
public class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("修饰内心");
        super.operation();
    }
}
