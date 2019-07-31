package com.pazz.java.core.datatype;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: 彭坚
 * @create: 2018/12/12 15:50
 * @description:
 */
public class String_Operation_Test {

    public static void main(String[] args) {

        /**
         * char 类型 只能占一个位置 无论汉字还是字母 (二个字节)
         *  char ca = 'A';
         *  char cb = '汉';
         *  int cd = cb + cc;
         *  char ce = 'a' + 'b';
         */

        String strA = "湘A883KJ";
        //  Tests if this string starts with the specified prefix.
        System.out.println("前缀是否匹配: " + strA.startsWith("湘A")); //测试这个字符串是否以指定的前缀开始。

        String plate = "abc YY dd 6666 6";
        System.out.println("全部小写: " + plate.toLowerCase()); //小写
        System.out.println("全部大写: " + plate.toUpperCase()); //大写
        System.out.println("是否包含字符: " + plate.contains("YY"));
        List<String> lists = Arrays.asList(plate.split(" "));
        System.out.println("分割字符: " + lists.toString());

        String names = StringUtils.join(lists, ",");
        System.out.println("分开拼接: " + names);
        System.out.println("字符所在下标: " + names.lastIndexOf("6"));

        //正则匹配
        Pattern pattern = Pattern.compile(names);
        Matcher matcher = pattern.matcher("a");
        System.out.println(matcher.matches());

        testStringTime();
    }

    public static void testStringTime() {
        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            buffer.append("&" + i);
        }
        System.out.println((System.currentTimeMillis() - start2));
        System.out.println(buffer.length());
        System.out.println("存在缓存");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            builder.append("&" + i);
        }
        System.out.println((System.currentTimeMillis() - start));
        System.out.println(builder.length());
    }

}
