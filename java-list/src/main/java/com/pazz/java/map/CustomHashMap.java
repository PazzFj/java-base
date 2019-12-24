package com.pazz.java.map;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/12 22:09
 * @description: 自定义HashMap
 */
public class CustomHashMap<K, V> implements CustomMap<K, V> {

    private static int defaultLength = 1 << 4; // aka 16
    private static float defaultFactor = 0.75f;
    private volatile int useSize;
    private Node<K, V>[] table = null;
    private Node<K, V>[] newTable = null;

    public CustomHashMap() {
        this(defaultLength, defaultFactor);
    }

    public CustomHashMap(int length, float factor) {
        if (length < 0) {
            throw new IllegalArgumentException("参数不能为负数" + length);
        }
        if (factor <= 0 && Double.isNaN(factor)) {
            throw new IllegalArgumentException("扩容标准必须是大于0的数字" + factor);
        }
        this.defaultLength = length;
        this.defaultFactor = factor;
        table = new Node[defaultLength];
    }

    @Override
    public V put(K key, V value) {
        // 当前长度 > 默认长度*默认负载因子   ======>扩容
        if (useSize > defaultLength * defaultFactor) {
            up2Size();
        }
        int index = getIndex(key, table.length);
        Node<K, V> node = table[index];
        if(node == null){
            table[index] = new Node<>(key, value, null);
        }else if(node != null){
            table[index] = new Node<>(key, value, node);
        }
        useSize ++;
        return table[index].getValue();
    }

    @Override
    public int size() {
        return useSize;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key, table.length);
        if(table[index] == null){
            throw new NullPointerException();
        }
        return findValueByEqualKey(key, table[index]);
    }

    // 扩容 并 散列
    private void up2Size() {
        newTable = new Node[defaultLength * 2];
        againHash(newTable);
    }

    // 散列
    private void againHash(Node<K, V>[] newTable) {
        List<Node<K, V>> nodes = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            foundNoteByNext(table[i], nodes);
        }

        //散列
        if (nodes.size() > 0) {
            defaultLength = 2 * defaultLength;
            useSize = 0;
            nodes.forEach(node -> {
                if (node.next != null) {
                    node.next = null;
                }
                put(node.getKey(), node.getValue());
            });
        }
    }

    // 经典查找链表值 ---->> 递归方式
    private void foundNoteByNext(Node<K, V> node, List<Node<K, V>> nodeList){
        if(node.next != null){
            nodeList.add(node);
            // 递归方式 得到下面所有得数据
            foundNoteByNext(node.next, nodeList);
        }else{
            nodeList.add(node);
        }
    }

    private int getIndex(K key, int length) {
        int m = length - 1;
        int index = hash(key.hashCode()) & m;
        return index;
    }

    private int hash(int hashCode) {
        hashCode = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
        return hashCode ^ ((hashCode >>> 7) ^ (hashCode >>> 4));
    }

    // 根据Key 跟 Node得Key 去匹配
    private V findValueByEqualKey(K key, Node<K, V> node){
        if(key == node.getKey() || key.equals(node.getKey())){
            return node.getValue();
        }else if(node.next != null){
            // 继续往下找
            return findValueByEqualKey(key, node.next);
        }
        return null;
    }

    class Node<K, V> implements CustomMap.IEntry<K, V> {
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

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if(table != null){
            for (int i = 0; i < table.length; i++) {
                sb.append(table[i].k + "=" + table[i].v + ",");
                Node next = table[i].next;
                while(next != null){
                    sb.append(next.k + "=" + next.v + ",");
                    next = next.next;
                }
            }
            return sb.toString();
        }
        return null;
    }
}
