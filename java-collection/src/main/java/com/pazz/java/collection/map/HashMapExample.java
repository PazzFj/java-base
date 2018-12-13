package com.pazz.java.collection.map;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/12 22:09
 * @description:
 */
public class HashMapExample<K, V> implements IMap<K, V> {

    private static int defaultLength = 1 << 4; // aka 16
    private static float defaultFactor = 0.75f;
    private volatile int useSize;

    private Node<K, V>[] table = null;
    private Node<K, V>[] newTable = null;

    public HashMapExample() {
        this(defaultLength, defaultFactor);
    }

    public HashMapExample(int length, float factor) {
        if (length < 0) {
            throw new IllegalArgumentException("参数不能为负数" + length);
        }
        if (factor <= 0 && Double.isNaN(factor)) {
            throw new IllegalArgumentException("扩容标准必须是大于0的数字" + factor);
        }
        defaultLength = length;
        defaultFactor = factor;
        table = new Node[length];
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (useSize > defaultLength * defaultFactor) {
            upSize();
        }
        int index = getIndex(key, table.length);
        Node<K, V> node = table[index];
        if (node == null) {
            table[index] = new Node<>(key, value, null);
            useSize ++; //使用长度增加了
        }else{
            //添加在原有的链表头中
            table[index] = new Node<>(key, value, node);
        }
        return table[index].getValue();
    }

    @Override
    public int size() {
        return 0;
    }

    //key对应的下标
    private int getIndex(K key, int length) {
        int m = length - 1;
        int index = hash(key.hashCode()) & m;
        return index;
    }

    //哈希算法
    private int hash(int hashCode) {
        hashCode = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
        return hashCode ^ ((hashCode >>> 7) ^ (hashCode >>> 4));
    }

    //扩容
    private void upSize() {
        newTable = new Node[defaultLength * 2];
        againHash(newTable);
    }

    //散列
    private void againHash(Node<K, V>[] newTable) {
        List<Node<K, V>> lists = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            foundNoteByNext(table[i], lists);
        }
        if (lists.size() > 0) {
            defaultLength = defaultLength * 2;
            useSize = 0;
            lists.forEach(node -> {
                if (node.next != null) {
                    node.next = null;
                }
                put(node.getKey(), node.getValue());
            });
        }
    }

    //查找下一个值
    private void foundNoteByNext(Node<K, V> kvNode, List<Node<K, V>> lists) {
        lists.add(kvNode);
        if (kvNode.next != null) {
            foundNoteByNext(kvNode.next, lists);
        }
    }

    class Node<K, V> implements IMap.IEntry<K, V> {
        K k;
        V v;
        Node<K, V> next;

        public Node(K k, V v, Node<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }


}
