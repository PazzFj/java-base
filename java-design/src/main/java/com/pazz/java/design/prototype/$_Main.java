package com.pazz.java.design.prototype;

/**
 * @author: Peng Jian
 * @create: 2020/1/2 20:41
 * @description: 原型模式
 */
public class $_Main {
    public static void main(String[] args) throws Exception {
        //prototype  -------->> Object.clone(); 克隆
        //加载数据
        ShapeCache.loadCache();
        Shape shape = ShapeCache.getShape("2");
        System.out.println(shape);
    }
}
