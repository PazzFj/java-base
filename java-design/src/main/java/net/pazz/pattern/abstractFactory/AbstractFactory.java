package net.pazz.pattern.abstractFactory;

/**
 * @author: 彭坚
 * @create: 2018/9/17 15:35
 * @description:
 */
public abstract class AbstractFactory<T> {

    abstract T createFactory(String obj);

}
