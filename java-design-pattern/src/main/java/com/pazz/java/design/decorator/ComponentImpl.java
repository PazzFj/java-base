package com.pazz.java.design.decorator;

/**
 * @author: 彭坚
 * @create: 2018/12/24 17:26
 * @description: 装饰器模式：(具体实现类)
 */
public class ComponentImpl implements Component {

    @Override
    public void operation() {
        System.out.println("具体...");
    }

}
