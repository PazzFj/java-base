package com.pazz.java.design.prototype.shape;

import com.pazz.java.design.prototype.Shape;

/**
 * @author: Peng Jian
 * @create: 2018/9/29 15:33
 * @description: 长方形
 */
public class Rectangle extends Shape {

    public Rectangle(String id, String type) {
        super.type = type;
    }

    @Override
    public void draw() {
        System.out.println("Rectangle Rectangle Rectangle   ");
    }
}
