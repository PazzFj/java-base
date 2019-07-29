package com.pazz.java.core.datatype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: 彭坚
 * @create: 2019/7/29 22:19
 * @description:
 */
public class Array_List_Test {

    public static void main(String[] args) {

        List<String> lists = newArrayLists();
        Object[] objects = lists.toArray();
        System.out.println("新集合: " + lists);
        System.out.println("新数组: " + objects);
//        lists.forEach(ss -> System.out.println(ss));
        //复制 （源数据, 长度, 数据类型）
        objects = Arrays.copyOf(objects, lists.size(), Object[].class);
        System.out.println("复制数组: " + objects);

        Object[] dest = new Object[10];
        //src:源数组；    srcPos:源数组要复制的起始位置；    dest:目的数组；   destPos:目的数组放置的起始位置；   length:复制的长度。
        System.arraycopy(objects, 10, dest, 5, 5); //之前元素也会存在
        System.out.println(Arrays.asList(dest));

        Collections.sort(lists);//集合排序    底层1、lists.sort(null);    2、Arrays.sort(数组);
        System.out.println(lists);

        List<String> strings = lists.subList(0, 1);
        System.out.println(strings);
    }

    public static List newArrayLists() {
        List<String> lists = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                lists.add("O=" + i);
            } else {
                lists.add("J=" + i);
            }
        }
        return lists;
    }

}
