package net.pazz.design;

import net.pazz.design.abstractFactory.AbstractFactory;
import net.pazz.design.abstractFactory.FactoryProducer;
import net.pazz.design.abstractFactory.color.Color;
import net.pazz.design.abstractFactory.shape.Shape;

/**
* @description: 抽象工厂模式
* @author: Peng Jian
* @date: 2018/5/30 10:09
*/
public class AbstractFactoryExample {

    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory<Shape> shapeFactory = FactoryProducer.getFactory("SHAPE");

        //获取形状为 Circle 的对象
        Shape shape1 = shapeFactory.get("CIRCLE");

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取形状为 Rectangle 的对象
        Shape shape2 = shapeFactory.get("RECTANGLE");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取形状为 Square 的对象
        Shape shape3 = shapeFactory.get("SQUARE");

        //调用 Square 的 draw 方法
        shape3.draw();

        //获取颜色工厂
        AbstractFactory<Color> colorFactory = FactoryProducer.getFactory("COLOR");

        //获取颜色为 Red 的对象
        Color color1 = colorFactory.get("Red");

        //调用 Red 的 fill 方法
        color1.fill();

        //获取颜色为 Green 的对象
        Color color2 = colorFactory.get("Green");

        //调用 Green 的 fill 方法
        color2.fill();

        //获取颜色为 Blue 的对象
        Color color3 = colorFactory.get("Blue");

        //调用 Blue 的 fill 方法
        color3.fill();
    }

}
