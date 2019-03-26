package net.pazz.base;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Peng Jian
 * @date: 2018/5/31 17:04
 * @description:
 */
public class MapMain {

    public static void main(String[] args) {
//        MyMap<String, String> myMap = new MyHashMap<>();
//        for (int i = 0; i < 10; i++) {
//            myMap.put("key" + i, "value" + i);
//        }
//        String value = myMap.get("key5");
//        System.out.println(value);

        Map<String, Integer> map = new HashMap<>();
        map.put("k", 1);
        map.put("k", 3);
        map.put("k", 2);
        System.out.println(map);
        map = new Hashtable<>();
        map.put("k2", 1);
        map.put("k2", 2);
        map.put("k2", 3);
        System.out.println(map);

        map = new ConcurrentHashMap<>();
        map.put("k3", 1);
        map.put("k3", 1);
        map.put("k3", 3);
        System.out.println(map);

//        Test test = new Test();
//        test.getObjects().add("aa");
//        System.out.println(test.getObjects());


    }


    @Data
    static class Test {
        private List<Object> objects = new ArrayList<>();
    }

}
