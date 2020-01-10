package com.pazz.java.design.adapter;

/**
 * @author: 彭坚
 * @create: 2018/12/25 20:49
 * @description: 适配器Adapter继承自 {@link Adaptee}，同时又实现了目标{@link Target}接口。
 */
public class Adapter extends Adaptee implements Target {

    //目标接口要求调用Request()这个方法名，但源类Adaptee没有方法Request()
    //因此适配器补充上这个方法名
    //但实际上Request()只是调用源类Adaptee的SpecificRequest()方法的内容
    //所以适配器只是将SpecificRequest()方法作了一层封装，封装成Target可以调用的Request()而已
    @Override
    public void request() {
        this.specificRequest();
        System.out.println("我是适配器");
    }

}
