package com.pazz.java.collection;

/**
 * @author: Peng Jian
 * @create: 2018/10/30 9:36
 * @description: 值传递与对象传递
 */
public class ValTransmit {

    public static void main(String[] args) {
        String s1 = new String("pengjian");
        String s2 = s1;
        s1 = "sss";
        System.out.println(s2);

        int i1 = 100;
        int i2 = i1;
        i1 = 101;
        System.out.println(i2);

        Example example1 = new Example("test1");
        Example example2 = example1;
        example1.setAttr("test2");
        System.out.println(example2);
    }

}
