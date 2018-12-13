package com.pazz.java.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 彭坚
 * @create: 2018/12/13 13:55
 * @description:
 */
public class HashMapTest {

    public static void main(String[] args) {
        IMap<String, String> map = new HashMapExample<>();
        for (int i = 0; i < 300; i++) {
            map.put("k_" + i, "v_" + i);
        }
        System.out.println(map.size());

//        Map<Test, Test> map2 = new HashMap<>();
//        for (int i = 0; i < 300; i++) {
//            map2.put(new Test("test"), new Test("test"));
//        }
    }

    static class Test{

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
