package net.pazz.design.prototype;

import net.pazz.design.prototype.shape.Circle;
import net.pazz.design.prototype.shape.Rectangle;
import net.pazz.design.prototype.shape.Square;

import java.util.Hashtable;

public class ShapeCache {

    private static Hashtable<String, Shape> hashTable = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) throws CloneNotSupportedException {
        Shape shape = hashTable.get(shapeId);
        return (Shape) shape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        hashTable.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        hashTable.put(rectangle.getId(), rectangle);

        Square square = new Square();
        square.setId("3");
        hashTable.put(square.getId(), square);
    }
}
