package com.pazz.java.define;

/**
 * @author: Peng Jian
 * @create: 2020/1/3 14:13
 * @description:
 */
public class $_Main {

    public static void main(String[] args) {
        TestTypeEnum typeEnum = TestTypeEnum.valueOf("BMW_TYPE");
        System.out.println(typeEnum.getName());
    }

}
