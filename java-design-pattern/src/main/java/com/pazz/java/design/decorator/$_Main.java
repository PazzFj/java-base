package com.pazz.java.design.decorator;

/**
 * 装饰者模式
 *
 * @Auther peng jian
 * @Date 2020/1/2 16:31
 */
public class $_Main {
    public static void main(String[] args) {
        System.out.println("****************装饰器模式***************");
        Component component = new ComponentImpl();//具体组件
        Decorator decorator1 = new Decorator(component, "装饰1");
        Decorator decorator2 = new Decorator(decorator1, "装饰2");
        Decorator decorator3 = new Decorator(decorator2, "装饰3");
        decorator3.operation();
    }
}
