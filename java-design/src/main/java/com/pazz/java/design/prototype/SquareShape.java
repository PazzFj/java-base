package com.pazz.java.design.prototype;

import com.pazz.java.design.prototype.Shape;

/**
 * @author: Peng Jian
 * @create: 2018/9/29 15:34
 * @description: 正方形
 */
public class SquareShape extends Shape {

    public SquareShape(String id, String type) {
        setId(id);
        super.type = type;
    }

    @Override
    public void draw() {
        System.out.println("Square Square Square");
    }

    @Override
    public String toString() {
        return "Square{" +
                "type='" + type + '\'' +
                '}';
    }
}
