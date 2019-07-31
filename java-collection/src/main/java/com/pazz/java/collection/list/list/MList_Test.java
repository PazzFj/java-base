package com.pazz.java.collection.list.list;

import java.util.Iterator;

/**
 * @author: 彭坚
 * @create: 2018/9/11 16:32
 * @description:
 */
public class MList_Test {

    public static void main(String[] args) {
        MList<String> mList = new MArrayList<>(0);
        mList.add("11");
        mList.add("22");
        mList.add("33");

        Iterator iterator = mList.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }

    }

}
