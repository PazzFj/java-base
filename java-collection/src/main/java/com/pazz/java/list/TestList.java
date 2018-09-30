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
        // ArrayList extends AbstractList implements List, Collection, Iterable
        List<String> a = new ArrayList<>();
        List<String> b = new LinkedList<>();
        List<String> c = new Vector<>();

        /**
         *                  initialCapacity     data structure
         * Vector           10                  Object[]
         * LinkedList       无                   Node
         * ArrayList        10                  Object[]
         *
         */



    }

}
