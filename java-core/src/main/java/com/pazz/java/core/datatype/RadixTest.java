package com.pazz.java.core.datatype;

/**
 * @author: 彭坚
 * @create: 2018/12/12 22:27
 * @description: 基数,底数
 */
public class RadixTest {

    public static void main(String[] args) {
        //f结尾有 / d结尾无  / 默认结尾无
        double a = 0.2f;
        double b = 0.2d;
        double c = 0.2;
        System.out.println(a);      // 0.20000000298023224
        System.out.println(b);      // 0.2
        System.out.println(c);      // 0.2
        System.out.println(a + b);  // 0.40000000298023225
        System.out.println("************************");

        float f1 = 10f;
        float f2 = 10F;
        float f3 = 10L;
        float f4 = 10l;
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);
    }

}
