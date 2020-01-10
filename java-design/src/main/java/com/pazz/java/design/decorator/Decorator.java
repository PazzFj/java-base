package com.pazz.java.design.decorator;

/**
 * @author: 彭坚
 * @create: 2018/12/24 17:28
 * @description: 装饰器模式：(装饰类)
 */
public class Decorator implements Component {

    private Component component;
    private String extendsName;

    public Decorator(Component component, String extendsName) {
        this.component = component;
        this.extendsName = extendsName;
    }

    public String getExtendsName() {
        return extendsName;
    }

    @Override
    public void operation() {
        System.out.println(extendsName);
        component.operation();
    }

}
