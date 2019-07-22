package com.pazz.java.design.factory2;

/**
 * @author: 彭坚
 * @create: 2019/3/5 9:55
 * @description:
 */
public class WomanChook extends AbstractProperty implements Person {

    @Override
    public void eat() {
        System.out.println("女人吃鸡");
    }
}
