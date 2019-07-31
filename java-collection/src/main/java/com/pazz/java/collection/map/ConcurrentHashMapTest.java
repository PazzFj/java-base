package com.pazz.java.collection.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Peng Jian
 * @create: 2018/9/26 10:14
 * @description:
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        //null
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        // key and value is not null
        // int hash = spread(key.hashCode());
        int hashK1 = spread("k1".hashCode());
        concurrentHashMap.put("k1" ,"v1");   // 3366
        int hashK2 = spread("k2".hashCode());
        concurrentHashMap.put("k2" ,"v2");   // 3367
        int hashK3 = spread("k3".hashCode());
        concurrentHashMap.put("k3" ,"v3");   // 3368
        concurrentHashMap.put("k4" ,"v4");   // 3369
        concurrentHashMap.forEach((k,v) -> {
            System.out.println("key=" + k + "  value="+v);
        });
    }

    // 得到hash值
    static final int spread(int h) {
        return (h ^ (h >>> 16)) & 0x7fffffff;    // 2的31次幂 -1
    }

    private static Object[] table;
    private static int sizeCtl;
    private static final int DEFAULT_CAPACITY = 16;
//    private static final sun.misc.Unsafe U = sun.misc.Unsafe.getUnsafe();
    private static final long SIZECTL = 111;


    //初始化table
    private final Object[] initTable() {
        Object[] tab; int sc;
        while ((tab = table) == null || tab.length == 0) {
            if ((sc = sizeCtl) < 0)
                Thread.yield(); // lost initialization race; just spin
            /*else if (U.compareAndSwapInt(this, SIZECTL, sc, -1)) {
                try {
                    if ((tab = table) == null || tab.length == 0){
                        int n = (sc > 0) ? sc : DEFAULT_CAPACITY;
                        Object[] nt =new Object[n];
                        table = tab = nt;
                        sc = n - (n >>> 2);
                    }
                } finally {
                    sizeCtl = sc;
                }
                break;
            }*/
        }
        return tab;
    }

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    //确认容量大小
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
