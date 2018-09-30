package com.pazz.java.prototype.shape;

import com.pazz.java.prototype.Shape;

/**
 * @author: Peng Jian
 * @create: 2018/9/29 15:32
 * @description: 圆形
 */
public class Circle extends Shape {

    public Circle(String id, String type) {
        super.type = type;
    }

    @Override
    public void draw() {
        System.out.println("Circle Circle Circle");
    }
}
