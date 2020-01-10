package com.pazz.java.design.prototype;

import com.pazz.java.design.prototype.Shape;

/**
 * @author: Peng Jian
 * @create: 2018/9/29 15:32
 * @description: 圆形
 */
public class CircleShape extends Shape {

    public CircleShape(String id, String type) {
        setId(id);
        super.type = type;
    }

    @Override
    public void draw() {
        System.out.println("Circle Circle Circle");
    }

    @Override
    public String toString() {
        return "Circle{" +
                "type='" + type + '\'' +
                '}';
    }
}
