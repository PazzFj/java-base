package com.pazz.java.design.abstractFactory.factory;

import com.pazz.java.design.abstractFactory.AbstractFactory;
import com.pazz.java.design.abstractFactory.shape.Shape;

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
