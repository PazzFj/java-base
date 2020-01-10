package com.pazz.java.design.interpreter;


/**
 * @author: Peng Jian
 * @create: 2020/1/2 17:17
 * @description: interpreter 解释者模式
 */
public class $_Main {
    public static void main(String[] args) {
        Expression containsTest = new ExpressionContainsImpl("test");
        Expression containsName = new ExpressionContainsImpl("name");
        Expression and = new ExpressionAndImpl(containsTest, containsName);
        Expression or = new ExpressionOrImpl(containsTest, containsName);
        System.out.println(and.interpret("test"));
        System.out.println(or.interpret("name"));
    }
}
