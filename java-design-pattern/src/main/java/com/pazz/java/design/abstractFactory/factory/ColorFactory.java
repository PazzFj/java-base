package com.pazz.java.design.abstractFactory.factory;

import com.pazz.java.design.abstractFactory.AbstractFactory;
import com.pazz.java.design.abstractFactory.color.Color;

public class ColorFactory extends AbstractFactory<Color> {

    public Color get(String color) {
        try {
            return (Color) Class.forName(color).newInstance();
        } catch (Exception e) {
            System.err.println("----------反射出现问题了Color~");
            return null;
        }
    }

}
