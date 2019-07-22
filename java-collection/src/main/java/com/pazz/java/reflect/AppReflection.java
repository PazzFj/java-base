package com.pazz.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: 彭坚
 * @create: 2019/4/22 10:54
 * @description:
 */
public class AppReflection {

    public static void main(String[] args) {

        Class clazz = Student.class;

        Field[] fields = clazz.getDeclaredFields(); // 获取所有属性Field   getFields()
        Arrays.asList(fields).forEach(System.out::println);

        Method[] methods = clazz.getDeclaredMethods(); // 获取类所有方法Method  getMethods()
        System.out.println(Arrays.asList(methods));

        Constructor[] constructors = clazz.getDeclaredConstructors();  // 获取类所有构造器Constructor  getConstructors()
        System.out.println(Arrays.asList(constructors));

    }

}
