package com.pazz.java.design.prototype;

import java.util.Hashtable;

/**
 * @author: Peng Jian
 * @create: 2018/9/29 15:36
 * @description:
 */
public class ShapeCache {

    private static Hashtable<String, Shape> hashTable = new Hashtable<>();

    public static Shape getShape(String shapeId) throws CloneNotSupportedException {
        Shape shape = hashTable.get(shapeId);
        return (Shape) shape.clone();
    }

    /**
     * 加入缓存map中
     */
    public static void loadCache() {
        CircleShape circle = new CircleShape("1", "circle Type");
        hashTable.put(circle.getId(), circle);

        RectangleShape rectangle = new RectangleShape("2", "rectangle Type");
        hashTable.put(rectangle.getId(), rectangle);

        SquareShape square = new SquareShape("3", "square Type");
        hashTable.put(square.getId(), square);
    }

}
