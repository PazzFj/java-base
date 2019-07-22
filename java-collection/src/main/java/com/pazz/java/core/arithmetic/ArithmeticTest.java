package com.pazz.java.core.arithmetic;

/**
 * @author: 彭坚
 * @create: 2018/12/12 11:02
 * @description: 算法
 */
public class ArithmeticTest {

    public static void main(String[] args) {
        int a,b;
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
