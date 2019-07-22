package com.pazz.java.design.factory;

/**
 * @author: 彭坚
 * @create: 2019/2/28 14:30
 * @description:
 */
public abstract class AbstractFactory<T> {

    public abstract T getObject(String str);

}
