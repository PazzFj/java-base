package net.pazz.design.prototype.shape;

import net.pazz.design.prototype.Shape;

public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
