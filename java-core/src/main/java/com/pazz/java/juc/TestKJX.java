package com.pazz.java.juc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: 彭坚
 * @create: 2019/1/10 11:00
 * @description:
 */
public class TestKJX {
    private static ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<String, String>();

    public static void main(String[] args) {
        addData(hashMap);
        for (int i = 0; i < 10; i++) {
            DemoThread thread = new DemoThread(hashMap, "kk" + i, "vv" + i);
            new Thread(thread).start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---" + hashMap.size());
    }

    public static void addData(Map<String, String> map) {
        for (int i = 0; i < 200; i++) {
            map.put("k" + i, "v" + 1);
        }
    }

    static class DemoThread implements Runnable {
        private ConcurrentHashMap<String, String> map = null;
        private String key;
        private String val;

        public DemoThread(ConcurrentHashMap<String, String> map, String key, String val) {
            this.map = map;
            this.key = key;
            this.val = val;
        }

        @Override
        public void run() {
            for (int j = 0; j < 50; j++) {
                map.put(key + "_" + j, val + "_" + j);
            }
        }

        public int getCount() {
            return map.size();
        }
    }

}
