package com.pazz.java.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author: 彭坚
 * @create: 2019/4/18 9:51
 * @description:
 */
public class TestLinkedHashMap {

    public static void main(String[] args) {

        Map<Object, Object> map = new LinkedHashMap<Object, Object>();
        test(f -> "bbbb", "aaaa");
    }

    public static Object test (Function function, String ss){
        Object obj = function.apply(ss);
        System.out.println(obj);
        return obj;
    }

}
