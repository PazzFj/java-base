package net.pazz.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Peng Jian
 * @create: 2018/9/18 17:29
 * @description:
 */
public class HashMapTest {

    public static void main(String[] args) {
        // initialization
        // HashMap()  ===>>   loadFactor = 0.75f
        Map<String, String> map = new HashMap<>();
        // HashMap 允许空值
        // putVal(hash(key), key, value, onlyIfAbsent, evict) >> (哈希k值, 键, 值, false, true)
        // hash(key)    ===>>     (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        // resize()     ===>>     initialCapacity = 1 << 4;    threshold = 0.75f * initialCapacity = 11
        // newCap = oldCap << 1      initialCapacity ===>> 16  32  64  128
        // newThr = newCap * loadFactor    16 * 0.75 ===>>  12  24  48  96
        map.put("qq", "ww");
        map.put("aa", "ss");
        map.put("zz", "xx");
        System.out.println(map);
        String value = map.get("qq");
        System.out.println(value);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
