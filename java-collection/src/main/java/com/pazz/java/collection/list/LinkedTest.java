package com.pazz.java.collection.list;

/**
 * @author: Peng Jian
 * @create: 2018/9/30 10:13
 * @description:
 */
public class LinkedTest {

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
        LinkedListExample<String> linkedList = new LinkedListExample<>();

        linkedList.add("aaa");
        linkedList.add("vvv");
        linkedList.add("sss");
        linkedList.add(2, "pengjian");
        String value = linkedList.get(4);
        System.out.println(value);
    }

}
