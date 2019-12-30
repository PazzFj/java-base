package com.pazz.java.data.type;

import java.math.BigDecimal;

/**
 * @author: 彭坚
 * @create: 2018/12/12 10:06
 * @description: 算法操作 Arithmetic Operations
 */
public class BigDecimalType {

    public static void main(String[] args) {
        //中通面试经历

        //当{@code BigDecimal}在数值上小于、等于或大于{@code val}时，为-1、0或1。
        BigDecimal b1 = new BigDecimal(0.9999);
        System.out.println(b1.intValue());
        System.out.println("比较大小：-1小于、0等于、1大于 = " + b1.compareTo(BigDecimal.ONE));
        System.out.println("************************");

        //string与int的区别
        BigDecimal b2 = new BigDecimal(1111111.222222);  //new BigDecimal(1111111.222222, MathContext.DECIMAL32);
        BigDecimal b3 = new BigDecimal("333333.45444444");
        b3 = b3.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println("字符串与双精点区别: " + b2);
        System.out.println("字符串与双精点区别: " + b3);
        System.out.println("************************");

        BigDecimal bd1 = new BigDecimal("1.5");
        BigDecimal bd2 = new BigDecimal("1.5");
        BigDecimal bd3;
        bd3 = bd1.add(bd2);         //相加

        bd3 = bd1.multiply(bd2);    //相乘

        bd3 = bd1.divide(bd2);      //相除

        bd3 = bd1.subtract(bd2);    //相减

        //去除小数点(返回int 类型)
        System.out.println(bd3.intValue());

        // Exception in thread "main" java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
        // 算法异常("无穷小数扩张;没有确切的可表示的小数结果。")

    }

}
