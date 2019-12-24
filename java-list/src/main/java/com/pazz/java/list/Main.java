package com.pazz.java.list;

import java.util.Iterator;

/**
 * @author: 彭坚
 * @create: 2018/9/11 16:32
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        CustomList<String> customList = new CustomArrayList<>(0);
        customList.add("11");
        customList.add("22");
        customList.add("33");

        Iterator iterator = customList.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }

    }

}
