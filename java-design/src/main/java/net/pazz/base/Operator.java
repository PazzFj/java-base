package net.pazz.base;

/**
 * @author: 彭坚
 * @create: 2018/9/14 11:01
 * @description: java 运算符
 */
public class Operator {

    public static void main(String[] args) {
        int i = 12;
        int j = 20;


        System.out.println(i >> 1);
        System.out.println(j >> 1);
        System.out.println(i << 1);
        System.out.println(j << 1);
        System.out.println(" ************ ");
        System.out.println(i >> 2);
        System.out.println(j >> 2);
        System.out.println(i << 2);
        System.out.println(j << 2);
        System.out.println(" ************ ");
        System.out.println(j << 0);
        System.out.println(j >> 0);
    }

}
