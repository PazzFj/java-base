package com.pazz.java.collection.map;

/**
 * @author: 彭坚
 * @create: 2018/12/12 22:09
 * @description:
 */
public class HashMapExample<K, V> implements IMap<K, V> {

    private static int defaultLength = 1 << 4; // aka 16
    private static float defaultFactor = 0.75f;
    private volatile int size;

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
        Node<K, V> node = getNode(hash(key), key);
        if (node == null) {
            throw new NullPointerException();
        }
        return node.value;
    }

//    private V findValueByEqualKey(K key, Node<K, V> kvNode) {
//        if (kvNode.getKey() == key || kvNode.getKey().equals(key)) {
//            return kvNode.getValue();
//        } else if (kvNode.next != null) {
//            return findValueByEqualKey(key, kvNode.next);
//        }
//        return null;
//    }

    @Override
    public V put(K key, V value) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i;
        int hash = hash(key);
        if ((tab = table) == null || (n = tab.length) == 0) {
            n = upSize().length;
        }
        if ((p = tab[(i = n - 1 & hash)]) == null) {
            tab[i] = new Node<>(hash, key, value, null);
        } else {
            Node<K, V> e;
            K k;
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
                e = p;
            } else {
                for (int binCount = 0; ; ++binCount) {
                    if((e = p.next) == null){
                        p.next = new Node<>(hash, key, value, null);
                        break;
                    }
                    //如果下一个e的hash不等于当前hash 并且 e的key值也不等key
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if(e != null){ //已存在该key值了
                V oldValue = e.value;
                return oldValue;
            }
        }
        if(++size > defaultLength * defaultFactor){
            upSize();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    //根据hash与key 查找value
    private Node<K, V> getNode(int hash, Object key) {
        Node<K, V>[] tab;
        Node<K, V> first, e;
        K k;
        int n;
        if ((tab = table) != null && (n = tab.length) > 0 && (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && ((k = first.key) == key || (key != null && key.equals(k)))) {
                return first;
            }
            if ((e = first.next) != null) {
                do {
                    if (e.hash == hash && ((k = e.key) == key) && (key != null && key.equals(k))) {
                        return e;
                    }
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

    /**
     * 计算key.hashCode()并将(XORs)散列的高位分散到低位。由于表使用的是幂- 2掩码，
     * 因此在当前掩码之上仅以位为单位变化的散列集总是会发生冲突。(已知的例子包括在小表中保存连续整数的浮动键集)因此，
     * 我们应用了一种转换，它可以向下传播更高位的影响。比特传播的速度、效用和质量之间存在权衡。
     * 因为许多常见的散列集已经合理分布(所以不要受益于传播),因为我们用树来处理大型的碰撞在垃圾箱,
     * 我们只是XOR一些改变以最便宜的方式来减少系统损耗,以及将最高位的影响,否则永远不会因为指数计算中使用的表。
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    //扩容
    private Node<K, V>[] upSize() {
        newTable = new Node[defaultLength * 2];
        againHash(newTable);
        return newTable;
    }

    //散列
    private void againHash(Node<K, V>[] newTable) {
        Node<K, V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        table = newTable;
        if(oldTab != null){
            for (int j = 0; j < oldCap; ++j) {
                Node<K, V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if(e.next == null){
                        newTable[e.hash & (newTable.length - 1)] = e;
                    }else {
                        Node<K,V> next;
                        do{
                            next = e.next;
                            Node<K,V> loHead = null, loTail = null;
                            Node<K,V> hiHead = null, hiTail = null;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                            if (loTail != null) {
                                loTail.next = null;
                                newTable[j] = loHead;
                            }
                            if (hiTail != null) {
                                hiTail.next = null;
                                newTable[j + oldCap] = hiHead;
                            }
                        }while((e = next) != null);
                    }
                }
            }
        }
//        List<Node<K, V>> lists = new ArrayList<>();
//        for (int i = 0; i < table.length; i++) {
//            if (table[i] == null) {
//                continue;
//            }
//            foundNoteByNext(table[i], lists);
//        }
//        if (lists.size() > 0) {
//            defaultLength = defaultLength * 2;
//            for (int i = 0; i < lists.size(); i++) {
//                Node<K, V> node = lists.get(i);
//                if (node != null) {
//                    newTable[hash(node.key) & defaultLength - 1] = node;
//                }
//            }
//            table = newTable;
//        }
    }

//    //查找下一个值
//    private void foundNoteByNext(Node<K, V> kvNode, List<Node<K, V>> lists) {
//        lists.add(kvNode);
//        if (kvNode.next != null) {
//            foundNoteByNext(kvNode.next, lists);
//        }
//    }

    class Node<K, V> implements IMap.IEntry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K k, V v, Node<K, V> next) {
            this.hash = hash;
            this.key = k;
            this.value = v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }


}
