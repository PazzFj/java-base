package com.pazz.java.core.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: 彭坚
 * @create: 2018/12/19 14:25
 * @description:
 */
public class TestReflect {

    public static void main(String[] args) {
        Class clazz = SubCls.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

}
