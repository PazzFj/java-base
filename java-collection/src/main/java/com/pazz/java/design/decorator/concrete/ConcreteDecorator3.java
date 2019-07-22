package com.pazz.java.design.decorator.concrete;

import com.pazz.java.design.decorator.Component;
import com.pazz.java.design.decorator.Decorator;

/**
 * @author: 彭坚
 * @create: 2018/12/25 9:05
 * @description:
 */
public class ConcreteDecorator3 extends Decorator {

    public ConcreteDecorator3(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("修饰形态");
        super.operation();
    }
}
