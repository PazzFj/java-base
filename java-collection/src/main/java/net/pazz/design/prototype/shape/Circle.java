package net.pazz.design.prototype.shape;

import net.pazz.design.prototype.Shape;

public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
