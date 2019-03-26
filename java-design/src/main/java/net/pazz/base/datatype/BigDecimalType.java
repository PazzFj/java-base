package net.pazz.base.datatype;

import java.math.BigDecimal;

/**
 * @author: Peng Jian
 * @date: 2018/6/5 11:24
 * @description: BigDecimal
 */
public class BigDecimalType {

    public static void main(String[] args) {

        BigDecimal bigDecimal1 = new BigDecimal("0.1");
        //当{@code BigDecimal}在数值上小于、等于或大于{@code val}时，为-1、0或1。
        System.out.println(bigDecimal1.compareTo(BigDecimal.ZERO));


        BigDecimal bigDecimal2 = new BigDecimal(1.1);
        BigDecimal bigDecimal3 = new BigDecimal("1.1");
        System.out.println(bigDecimal2); // 1.100000000000000088817841970012523233890533447265625
        System.out.println(bigDecimal3); // 1.1
        double a = 1.1f;
        double b = 2.2d;
        double c = 3.0;
        System.out.println(a);      // 0.10000000149011612
        System.out.println(b);      // 0.2
        System.out.println(c);      //
        System.out.println(a + b);  // 0.30000000447034836

        BigDecimal decimal1 = new BigDecimal(1.1);
        BigDecimal decimal2 = new BigDecimal("1.1");
        BigDecimal decimal3 = new BigDecimal("2.11");
        System.out.println(decimal2 +" + " + decimal3 + " = " + decimal2.add(decimal3));      //加
        System.out.println(decimal1 +" * " + decimal2 + " = " + decimal1.multiply(decimal2)); //乘
        // Exception in thread "main" java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
        //算法异常("无穷小数扩张;没有确切的可表示的小数结果。")
//        System.out.println(decimal3 +" / " + decimal2 + " = " + decimal3.divide(decimal2));   //除
        System.out.println(decimal1 +" - " + decimal3 + " = " + decimal1.subtract(decimal3)); //减

        BigDecimal decimal = new BigDecimal("0");
        System.out.println(decimal.intValue());

    }
}
