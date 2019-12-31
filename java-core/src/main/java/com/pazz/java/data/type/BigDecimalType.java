package com.pazz.java.data.type;

import java.math.BigDecimal;

/**
 * @author: 彭坚
 * @create: 2018/12/12 10:06
 * @description: 算法操作 Arithmetic Operations
 */
public class BigDecimalType {

    public static void main(String[] args) {
        //string与int的区别

        BigDecimal bd1 = new BigDecimal("1.5");
        BigDecimal bd2 = new BigDecimal("2.5");
        BigDecimal addBig = bd1.add(bd2);               //相加
        BigDecimal multiplyBig = bd1.multiply(bd2);     //相乘
        BigDecimal divideBig = bd1.divide(bd2);         //相除
        BigDecimal subtractBig = bd1.subtract(bd2);     //相减

        //当{@code BigDecimal}在数值上小于、等于或大于{@code val}时，为-1、0或1。
        System.out.println("比较大小：小于-1、等于0、大于1 -> " + addBig.compareTo(multiplyBig));

        //去除小数点(返回int 类型)
        System.out.println(divideBig.intValue());
        System.out.println(subtractBig.intValue());

        // Exception in thread "main" java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
        // 算法异常("无穷小数扩张;没有确切的可表示的小数结果。")
    }

}
