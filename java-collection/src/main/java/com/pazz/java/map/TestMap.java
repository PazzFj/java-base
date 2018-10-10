package com.pazz.java.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Peng Jian
 * @create: 2018/10/9 15:39
 * @description:
 */
public class TestMap {

    public static void main(String[] args) {
        Map<String, String> mapA = new HashMap<>();
        Map<String, String> mapB = new Hashtable<>();
        Map<String, String> mapC = new ConcurrentHashMap<>();
        Map<String, String> mapD = new LinkedHashMap<>();


        /**
         *                          initialCapacity         data structure                  security            grow
         *    HashMap               16                      Node<K,V> / TreeNode<K,V>
         *    HashTable
         *    ConcurrentHashMap
         *
         */

    }

}
