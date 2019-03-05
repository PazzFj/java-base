package com.pazz.java.design.factory;

/**
 * @author: 彭坚
 * @create: 2019/2/28 14:28
 * @description:
 */
public class ModelFactory extends AbstractFactory<Model> {

    @Override
    public Model getObject(String str) {
        if ("rhombus".equals(str)) {
            return new RhombusModel();
        } else if ("square".equals(str)) {
            return new SquareModel();
        }
        return null;
    }
}
