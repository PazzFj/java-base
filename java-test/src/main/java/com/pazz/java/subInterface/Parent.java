package com.pazz.java.subInterface;

/**
 * @author: 彭坚
 * @create: 2019/3/4 15:06
 * @description:
 */
public interface Parent {

    default void test(){
        System.out.println("parent test");
    }

}
