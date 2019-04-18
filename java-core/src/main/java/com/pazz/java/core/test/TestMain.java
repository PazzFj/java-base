package com.pazz.java.core.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: 彭坚
 * @create: 2019/4/15 9:16
 * @description:
 */
public class TestMain {

    public static void main(String[] args) {
        String str1 = "[0-9]";
        String str2 = "[a-z]";
        Pattern pattern = Pattern.compile(str2);
        Matcher matcher = pattern.matcher("a");
        System.out.println(matcher.matches());
    }

}
