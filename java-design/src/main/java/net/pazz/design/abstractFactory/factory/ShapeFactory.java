package net.pazz.design.abstractFactory.factory;

import net.pazz.design.abstractFactory.AbstractFactory;
import net.pazz.design.abstractFactory.shape.Shape;

public class ShapeFactory extends AbstractFactory<Shape> {

    public Shape get(String shape) {
        try {
            return (Shape) Class.forName(shape).newInstance();
        } catch (Exception e) {
            System.err.println("----------反射出现问题了Shape~");
            return null;
        }
    }
}
