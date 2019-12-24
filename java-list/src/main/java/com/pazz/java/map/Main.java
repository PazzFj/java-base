package com.pazz.java.map;

/**
 * @author: 彭坚
 * @create: 2019/12/24 23:26
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        CustomMap<String, String> customMap = new CustomHashMap<>(2, 0.75f);
        customMap.put("张三", "test1234");
        customMap.put("李四", "88888888");
        customMap.put("王五", "898989");
        System.out.println(customMap.size());
        System.out.println(customMap.get("李四"));
    }

}
