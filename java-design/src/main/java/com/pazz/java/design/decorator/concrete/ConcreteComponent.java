package com.pazz.java.design.decorator.concrete;

import com.pazz.java.design.decorator.Component;

/**
 * @author: 彭坚
 * @create: 2018/12/24 17:26
 * @description: 装饰器模式：(具体实现类)
 */
public class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("具体...");
    }

}
