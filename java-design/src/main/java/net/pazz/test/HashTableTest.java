package net.pazz.test;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author: Peng Jian
 * @create: 2018/9/25 14:00
 * @description:
 */
public class HashTableTest {

    public static void main(String[] args) {
        // initialization
        // loadFactor = 0.75f
        // initialCapacity = 11
        // threshold = initialCapacity * loadFactor = 8
        Map<String, String> hashtable = new Hashtable();
        // Make sure the value is not null
        // index = (key.hashCode & 0x7FFFFFFF) % tab.length;
        // size >= threshold ===>> rehash()
        // rehash() ==>> (table.length * 2) + 1   = 23>47>95>191
        // threshold = newTable.length * 0.75f    = 17>35>71>143
        hashtable.put("qq", "ww");
        hashtable.put("aa", "ss");
        hashtable.put("zz", "xx");
        for (int a = 1; a<= 100;a++){
            hashtable.put("y"+a, "x"+a);
        }
//        String value = hashtable.get("zz");
//        System.out.println(value);
        System.out.println(hashtable);
    }

}
