package com.pazz.java.design.factory;

/**
 * @author: 彭坚
 * @create: 2019/2/28 14:29
 * @description:
 */
public class ColorFactory extends AbstractFactory<Color> {

    @Override
    public Color getObject(String str) {
        if("red".equals(str)){
            return new RedColor();
        }else if("black".equals(str)){
            return new BlackColor();
        }
        return null;
    }
}
