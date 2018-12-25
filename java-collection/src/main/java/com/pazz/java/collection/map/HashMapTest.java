package com.pazz.java.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: 彭坚
 * @create: 2018/12/13 13:55
 * @description:
 */
public class HashMapTest {

    @org.junit.Test
    public void test(){
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        String value = map.putIfAbsent("k1", "v3");
        System.out.println(value);
        System.out.println(map);
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 500; i++) {
            map.put("k_" + tableSizeFor(i), "v_" + tableSizeFor(i));
        }
        System.out.println(map);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= (1 << 30)) ? (1 << 30) : n + 1;
    }

    static class Test {
        private String key;

        public Test(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public int hashCode() {
            return 2018;
        }
    }

}
