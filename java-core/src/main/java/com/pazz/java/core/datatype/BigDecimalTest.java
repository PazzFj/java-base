package com.pazz.java.core.datatype;

import java.math.BigDecimal;

/**
 * @author: 彭坚
 * @create: 2018/12/12 10:06
 * @description: 算法操作 Arithmetic Operations
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        //中通面试经历

        //当{@code BigDecimal}在数值上小于、等于或大于{@code val}时，为-1、0或1。
        BigDecimal b1 = new BigDecimal(0.5);
        System.out.println(b1.compareTo(BigDecimal.ZERO));
        System.out.println("************************");

        //string与int的区别
        BigDecimal b2 = new BigDecimal(1.1);
        BigDecimal b3 = new BigDecimal("1.1");
        System.out.println(b2); // 1.100000...
        System.out.println(b3); // 1.1
        System.out.println("************************");

        //f结尾有 / d结尾无  / 默认结尾无
        double a = 0.2f;
        double b = 0.2d;
        double c = 0.2;
        System.out.println(a);      // 0.20000000298023224
        System.out.println(b);      // 0.2
        System.out.println(c);      // 0.2
        System.out.println(a + b);  // 0.40000000298023225
        System.out.println("************************");

        BigDecimal bd1 = new BigDecimal("1.5");
        BigDecimal bd2 = new BigDecimal("1.5");
        BigDecimal bd3 = new BigDecimal(BigDecimal.ROUND_UP);
        bd3 = bd1.add(bd2);         //相加
        System.out.println(bd3);
        bd3 = bd1.multiply(bd2);    //相乘
        System.out.println(bd3);
        bd3 = bd1.divide(bd2);      //相除
        System.out.println(bd3);
        bd3 = bd1.subtract(bd2);    //相减
        System.out.println(bd3);
        //去除小数点(返回int 类型)
        bd3.intValue();
        // Exception in thread "main" java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
        // 算法异常("无穷小数扩张;没有确切的可表示的小数结果。")

    }

}
