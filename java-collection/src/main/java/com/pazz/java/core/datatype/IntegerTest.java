package com.pazz.java.core.datatype;

import java.util.Arrays;
import java.util.List;

/**
 * Integer 缓存池 -128~127
 */
public class IntegerTest {

    public static void main(String[] args) {
        //自动装箱
        Integer i1 = Integer.valueOf(127);
        Integer i2 = Integer.valueOf(127);
        Integer i3 = 127; //Integer.valueOf(127);
        Integer i4 = 127; //Integer.valueOf(127);
        System.out.println(i1 == i2); // true
        System.out.println(i3 == i4); // true

        //二进制
        System.out.println(Integer.toBinaryString(10));
        //八进制
        System.out.println(Integer.toOctalString(10));
        //十六进制
        System.out.println(Integer.toHexString(10));

        int low = -128;
        int high = 127;
        //限制数组长度 (1~127)(-1~-128)(0)
        Integer[] cache = new Integer[(high - low) + 1];
        int j = low;
        // -128, -127, -126, -125, -124, -123, -122, -121, -120, -119, -118,........
        for (int i = 0; i < cache.length; i++) {
            cache[i] = new Integer(j++);
        }
        List<Integer> lists = Arrays.asList(cache);
        System.out.println(lists);
        System.out.println(cache[-128 + (-low)]);  //如果是大于0的数， 数组小标肯定大于128

    }

}
