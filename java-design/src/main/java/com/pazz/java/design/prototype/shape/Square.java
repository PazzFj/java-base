package com.pazz.java.design.prototype.shape;

import com.pazz.java.design.prototype.Shape;

/**
 * @author: Peng Jian
 * @create: 2018/9/29 15:34
 * @description: 正方形
 */
public class Square extends Shape {

    public Square(String id, String type) {
        super.type = type;
    }

    @Override
    public void draw() {
        System.out.println("Square Square Square");
    }
}
