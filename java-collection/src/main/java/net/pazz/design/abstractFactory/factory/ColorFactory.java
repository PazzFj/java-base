package net.pazz.design.abstractFactory.factory;

import net.pazz.design.abstractFactory.AbstractFactory;
import net.pazz.design.abstractFactory.color.Color;

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
