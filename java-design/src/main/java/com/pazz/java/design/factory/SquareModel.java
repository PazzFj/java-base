package com.pazz.java.design.factory;

/**
 * @author: 彭坚
 * @create: 2019/2/28 14:24
 * @description:
 */
public class SquareModel implements Model {
    @Override
    public String getShape() {
        return "正方形";
    }
}
