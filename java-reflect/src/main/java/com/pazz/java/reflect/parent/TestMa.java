package com.pazz.java.reflect.parent;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author: 彭坚
 * @create: 2019/5/16 17:50
 * @description:
 */
public class TestMa {

    public static void main(String[] args) {
        Class3 class3 = new Class3();
        Type type = class3.getClass().getGenericSuperclass();
        System.out.println(type instanceof ParameterizedType);
        System.out.println(type.getTypeName());
    }

}
