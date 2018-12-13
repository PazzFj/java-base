package com.pazz.java.collection.map;

/**
 * @author: 彭坚
 * @create: 2018/12/12 22:08
 * @description:
 */
public interface IMap<K, V> {

    V get(K key);

    V put(K key, V value);

    int size();

    interface IEntry<K, V> {
        K getKey();

        V getValue();
    }

}
