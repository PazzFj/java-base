package com.pazz.java.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author: 彭坚
 * @create: 2018/9/11 16:32
 * @description:
 */
public class $_Main {

    public static void main(String[] args) {
        Object[] objects = new Object[]{"1", "2", "3"};
        Object[] dest = new Object[3];
        //src:源数组； srcPos:源数组要复制的起始位置； dest:目的数组； destPos:目的数组放置的起始位置； length:复制的长度。
        System.arraycopy(objects, 1, dest, 0, 2);
        System.out.println(Arrays.asList(dest));

        //复制 (源数据, 长度, 数据类型)
        Object[] targetArr = Arrays.copyOf(objects, 5, Object[].class);
        System.out.println(Arrays.asList(targetArr));


        CustomList<String> customList = new CustomArrayList<>();
        customList.add("custom1");
        customList.add("custom2");
        customList.add("custom3");

        Iterator iterator = customList.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }

    }

}
