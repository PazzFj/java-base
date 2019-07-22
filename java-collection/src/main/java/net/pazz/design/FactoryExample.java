package net.pazz.design;

import net.pazz.design.factory.ShapeFactory;
import net.pazz.design.factory.shape.Circle;
import net.pazz.design.factory.shape.Rectangle;
import net.pazz.design.factory.shape.Shape;

/**
 * 工厂模式
 */
public class FactoryExample {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();
        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        //调用 Rectangle 的 draw 方法
        shape2.draw();
        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");
        //调用 Square 的 draw 方法
        shape3.draw();

        //反射得到Circle对象
        Circle circle = (Circle) shapeFactory.getClass(Circle.class);
        circle.draw();
        //反射得到Rectangle对象
        Rectangle rectangle = (Rectangle) shapeFactory.getClass(Rectangle.class);
        rectangle.draw();

    }

}
