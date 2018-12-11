package com.pazz.java.collection;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class IntCache
{
    public static void main( String[] args )
    {
        //自动装箱
        Integer ia = Integer.valueOf(16);
        int a = ia.intValue();
        System.out.println(a);

        int low = -128;
        int high = 127;
        //限制数组长度 (1~127)(-1~-128)(0)
        Integer[] cache = new Integer[(high - low) + 1];
        int j = low;
        for (int i = 0; i < cache.length; i++) {
            // -128, -127, -126, -125, -124, -123, -122, -121, -120, -119, -118,........
            cache[i] = new Integer(j++);
        }
        List<Integer> lists = Arrays.asList(cache);
        System.out.println(lists);
        System.out.println(cache[-128 + (-low)]);  //如果是大于0的数， 数组小标肯定大于128

    }
}
