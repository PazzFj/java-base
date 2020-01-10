package com.pazz.java.design.abstractFactory;

import com.pazz.java.design.abstractFactory.factory.ColorFactory;
import com.pazz.java.design.abstractFactory.factory.ShapeFactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("SHAPE"))
            return new ShapeFactory();
        if (choice.equalsIgnoreCase("COLOR"))
            return new ColorFactory();
        return null;
    }

}
