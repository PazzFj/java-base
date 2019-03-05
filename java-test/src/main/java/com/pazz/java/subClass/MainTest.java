package com.pazz.java.subClass;

/**
 * @author: 彭坚
 * @create: 2019/3/5 16:28
 * @description:
 */
public class MainTest {

    public static void main(String[] args) {
        ParentClass parentClass = new ParentClass();
        SubClass subClass = new SubClass();

        System.out.println(parentClass.getClass().isInstance(subClass));
    }

}
