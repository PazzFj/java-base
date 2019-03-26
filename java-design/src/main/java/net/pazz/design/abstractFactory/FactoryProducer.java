package net.pazz.design.abstractFactory;

import net.pazz.design.abstractFactory.factory.ColorFactory;
import net.pazz.design.abstractFactory.factory.ShapeFactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("SHAPE"))
            return new ShapeFactory();
        if (choice.equalsIgnoreCase("COLOR"))
            return new ColorFactory();
        return null;
    }

}
