package com.pazz.java.design.prototype;

import com.pazz.java.design.prototype.shape.Circle;
import com.pazz.java.design.prototype.shape.Rectangle;
import com.pazz.java.design.prototype.shape.Square;

import java.util.Hashtable;

/**
 * @author: Peng Jian
 * @create: 2018/9/29 15:36
 * @description:
 */
public class ShapeCache {

    private static Hashtable<String, Shape> hashTable = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) throws CloneNotSupportedException {
        Shape shape = hashTable.get(shapeId);
        return (Shape) shape.clone();
    }

    /**
     * 加入缓存map中
     */
    public static void loadCache() {
        Circle circle = new Circle("1", "circle Type");
        circle.setId("1");
        hashTable.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle("2", "rectangle Type");
        rectangle.setId("2");
        hashTable.put(rectangle.getId(), rectangle);

        Square square = new Square("3", "square Type");
        square.setId("3");
        hashTable.put(square.getId(), square);
    }

}
