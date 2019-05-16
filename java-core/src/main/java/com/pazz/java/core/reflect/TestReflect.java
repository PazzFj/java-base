package com.pazz.java.core.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: 彭坚
 * @create: 2018/12/19 14:25
 * @description:
 */
public class TestReflect {

    public static void main(String[] args) throws Exception {
        Class clazz = SubCls.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        TestReflect reflect = new TestReflect();
        Method method = reflect.getClass().getDeclaredMethod("methodA", String.class);
        Object result = method.invoke(reflect, "test");
        System.out.println("result: " + result);
    }

    private String methodA(String str){
        System.out.println("method:" + str);
        return str;
    }

}
