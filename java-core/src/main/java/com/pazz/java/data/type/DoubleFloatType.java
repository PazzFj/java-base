package com.pazz.java.data.type;

/**
 * @author: 彭坚
 * @create: 2018/12/12 22:27
 * @description: 基数,底数
 */
public class DoubleFloatType {

    public static void main(String[] args) {
        //f结尾有 / d结尾无  / 默认结尾无
        double a = 0.222f;
        double b = 0.333d;
        double c = 0.4444;
        Double d = Double.valueOf("0.5555");
        System.out.println("double: " + a);      // 0.20000000298023224
        System.out.println("double: " + b);      // 0.3
        System.out.println("double: " + c);      // 0.4
        System.out.println("valueOf: " + d);     // 0.55
        System.out.println("*************************************");

        float f1 = 10f;
        float f2 = 20l;
        float f3 = 30;
        float f4 = Float.valueOf("99999.9999");
        System.out.println("float: " + f1);     //10.0
        System.out.println("float: " + f2);     //20.0
        System.out.println("float: " + f3);     //30.0
        System.out.println("float: " + f4);     //100000.0
    }

}
