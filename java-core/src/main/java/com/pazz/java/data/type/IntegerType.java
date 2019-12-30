package com.pazz.java.data.type;

/**
 * Integer 缓存池 -128~127
 */
public class IntegerType {

    public static void main(String[] args) {
        //Integer 装箱、拆箱
        Integer i1 = Integer.valueOf(127);      //装箱
        Integer i3 = 127;                       //Integer.valueOf(127);
        System.out.println(i1 == i3);           // true

        //十进制转二进制
        System.out.println("十进制转二进制：" + Integer.toBinaryString(1616));   //0110 0101 0000
        //十进制转八进制
        System.out.println("十进制转八进制：" + Integer.toOctalString(1616));    //011 001 010 000   ==>   3,1,2,0
        //十进制转十六进制
        System.out.println("十进制转十六进制：" + Integer.toHexString(1616));    //0110 0101 0000    ==>   6,5,0

        int low = -128;
        int high = 127;
        // 限制数组长度 (1~127)(-1~-128)(包括0)
        Integer[] cache = new Integer[(high - low) + 1];
        int j = low;
        // -128, -127, -126, -125, -124, -123, -122, -121, -120, -119, -118,........
        for (int i = 0, length = cache.length; i < length; i++) {
            cache[i] = new Integer(j++);
        }
        // 如果是大于0的数， 数组小标肯定大于128
        System.out.println(cache[-128 + (-low)]);

        int a, b;
        a = 32;
        b = 45;
        System.out.println(Integer.toBinaryString(a));  //100000
        System.out.println(Integer.toBinaryString(b));  //101101

        System.out.println(a & b);      //如果相对应位都是1，则结果为1，否则为0
        System.out.println(a | b);      //如果相对应位都是0，则结果为0，否则为1
        System.out.println(a ^ b);      //如果相对应位值相同，则结果为0，否则为1
        int c = 32;
        System.out.println(Integer.toBinaryString(c));  //100000
        System.out.println(c >>> 3);   // (右移三位)  c除2^3
        System.out.println(c >> 1);    // (右移二位)  c除2^1
        System.out.println(c << 2);    // (左移二位)  c乘2^2

    }

}