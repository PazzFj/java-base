package com.pazz.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Peng Jian
 * @create: 2018/10/30 9:36
 * @description:
 */
public class ValTransmit {

    public static void main(String[] args) {
//        String[] s1 = {"aa", "bb", "cc", "dd"};
//        String[] s2 = s1;
//        s1[0] = "a";
//        s2[1] = "c";
//        for (int i = 0; i < s1.length; i++) {
//            System.out.print(s1[i]);
//        }
//        System.out.println();
//        for (int i = 0; i < s2.length; i++) {
//            System.out.print(s2[i]);
//        }

        String str1 = "abc";
        String str2 = str1;
        str1 = "acc";
        System.out.println(str2);
        System.out.println(str1);

    }

}
