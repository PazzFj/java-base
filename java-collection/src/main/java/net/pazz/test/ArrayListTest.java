package net.pazz.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/9/6 16:40
 * @description: 测试
 * @see ArrayList
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<String> list = newArrayList();
        System.out.println(list);

        Object[] os = new Object[10];
        List<String> lists = newLists();
        lists.forEach(ss -> System.out.println(ss));
        //复制数组 并转换成Object[]数组
        Object[] objects = Arrays.copyOf(lists.toArray(), lists.size(), Object[].class);
        //src:源数组； srcPos:源数组要复制的起始位置； dest:目的数组；destPos:目的数组放置的起始位置； length:复制的长度。
        System.arraycopy(objects, 2, os, 5, 2); //之前元素也会存在

        Arrays.copyOf(lists.toArray(), 1);//复制数组
        Collections.sort(lists);//集合排序
        lists.sort(null);//集合排序

        Arrays.sort(lists.toArray());
        lists.sort(null);
        lists.sort(null);
        System.out.println(lists);
        List<String> strings = lists.subList(2, 4);
        System.out.println(strings);
        String s = strings.get(1);
        System.out.println(s);
    }

    public static List newNames(){
        List<String> names = new ArrayList<>();
        names.add("A原子性");
        names.add("C一致性");
        names.add("I隔离性");
        names.add("D持久性");
        return names;
    }

    public static List newLists(){
        List<String> lists = new ArrayList<>();
        lists.add("aa");
        lists.add("bb");
        lists.add("dd");
        lists.add("ee");
        lists.add("cc");
        return lists;
    }

    public static List newArrayList(){
        List<String> lists = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lists.add("T=" + i);
        }
        return lists;
    }

}
