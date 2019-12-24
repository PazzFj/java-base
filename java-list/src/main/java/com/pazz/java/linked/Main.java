package com.pazz.java.linked;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Peng Jian
 * @create: 2018/9/30 10:13
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        /**
         * ArrayList ==>>  AbstractList  -->>  List<E> -->>  Collection<E> -->>  Iterable<E>
         *                      AbstractSequentialList<E>  ==>> AbstractList<E>
         * LinkedList<E>  ==>>  AbstractSequentialList<E>  -->>  Deque<E>/List<E>
         *
         *
         *                  initialCapacity     data structure      security        grow
         * Vector           10                  Object[]            Y               2倍
         * LinkedList       无                  Node                 N               无
         * ArrayList        10                  Object[]            N               1.5倍
         */
        CustomDeque<String> linkedList = new CustomLinkedList<>();

        linkedList.add("aaa");
        linkedList.add("vvv");
        linkedList.add("sss");
        linkedList.add(2, "pengjian");
        String value = linkedList.get(4);
        System.out.println(value);

        LinkedList<String> linked = (LinkedList<String>) newLinked();
        linked.peek();  //取第一个的值
        linked.pop();   //从列表中删除并返回第一个元素。
        linked.push("first");
        linked.addLast("last");
        linked.addFirst("First");
        System.out.println(linked);
    }

    public static List<String> newLinked(){
        List<String> names = new LinkedList<>();
        names.add("ZhangSan");
        names.add("LiSi");
        names.add("WangWu");
        names.add("ZhaoLiu");
        names.add("MaQi");
        return names;
    }

}
