package com.pazz.java.design.javassist.proxy;

/**
 * @author: 彭坚
 * @create: 2019/4/22 9:37
 * @description:
 */
public class Point {

    int x, y;

    void move(int dx, int dy) {
        { System.out.println(dx); System.out.println(dy); }
        x += dx; y += dy;
    }

}
