package com.pazz.java.design.factory;

/**
 * @author: 彭坚
 * @create: 2019/2/28 14:41
 * @description:
 */
public class FactoryProdive {

    public static AbstractFactory getFactory(String str) {
        if ("color".equals(str)) {
            return new ColorFactory();
        } else if ("model".equals(str)) {
            return new ModelFactory();
        }
        return null;
    }

}
