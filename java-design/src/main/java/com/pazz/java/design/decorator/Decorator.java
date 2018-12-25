package com.pazz.java.design.decorator;

/**
 * @author: 彭坚
 * @create: 2018/12/24 17:28
 * @description: 装饰器模式：(装饰类)
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }

}
