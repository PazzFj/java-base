package com.pazz.java.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author: Peng Jian
 * @create: 2018/9/30 10:13
 * @description:
 */
public class TestList {

    public static void main(String[] args) {
        //  List<E> ==>> Collection<E> ==>> Iterable<E>
        // ArrayList extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable
//        List<String> arrayList = new ArrayList<>();
//        List<String> vectorList = new Vector<>();
        // LinkedList extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable
        LinkedListExample<String> linkedList = new LinkedListExample<>();

        linkedList.add("aaa");
        linkedList.add("vvv");
        linkedList.add("sss");
        linkedList.add("zzz");
        linkedList.add("www");
        linkedList.add(4, "pengjian");
        String value = linkedList.get(4);

        System.out.println(value);

        /**
         *                  initialCapacity     data structure      security        grow
         * Vector           10                  Object[]            Y               2倍
         * LinkedList       无                  Node                 N               无
         * ArrayList        10                  Object[]            N               1.5倍
         */


    }

}
