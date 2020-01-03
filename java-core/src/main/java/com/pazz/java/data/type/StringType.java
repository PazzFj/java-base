package com.pazz.java.data.type;

import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: 彭坚
 * @create: 2018/12/12 15:50
 * @description: // 值传递 与 引用传递
 * // 引用传递是可以跨方法的.
 */
public class StringType {

    public static void main(String[] args) throws Exception {
        // 功能描述: enc ==> utf-8 or GBK
        String str = URLEncoder.encode("中文编码", "UTF-8");
        // 功能描述: example ==> MessageFormat.format("name = {0}   age = {1} ", "zs", 22)
        MessageFormat.format(str, args);
        // 功能描述: example ==> String.format("param1 = %s param2 = %x", "pengjian", 22)
        String.format(str, args);

        /**
         * char 类型 只能占一个位置 无论汉字还是字母
         *  char a = 'A';
         *  char b = '汉';
         *  int c = a + b;
         *  char d = 'a' + 'b';
         */
        String plate = "abc YY dd 6666 6";
        System.out.println("全部小写: " + plate.toLowerCase()); //小写
        System.out.println("全部大写: " + plate.toUpperCase()); //大写

        char[] chars = "ABC".toCharArray();
        char c = chars[0];
        System.out.println(c + 32);    // 小写 +32

        /**
         * 字符的取值范围
         * 1.[abc] : 表示可能是a，可能是b，也可能是c。
         * 2.[^abc]: 表示不是a,b,c中的任意一个
         * 3.[a-zA-Z]: 表示是英文字母
         * 4.[0-9]:表示是数字
         *
         * 简洁的字符表示
         * .：匹配任意的字符
         * \d：表示数字
         * \D：表示非数字
         * \s：表示由空字符组成，[ \t\n\r\x\f]
         * \S：表示由非空字符组成，[^\s]
         * \w：表示字母、数字、下划线，[a-zA-Z0-9_]
         * \W：表示不是由字母、数字、下划线组成
         *
         * 数量表达式
         * 1.?: 表示出现0次或1次
         * 2.+: 表示出现1次或多次
         * 3.*: 表示出现0次、1次或多次
         * 4.{n}：表示出现n次
         * 5.{n,m}：表示出现n~m次
         * 6.{n,}：表示出现n次或n次以上
         */
        //正则匹配
        String strb = "abczxcasd";
//        Pattern pattern = Pattern.compile("");
//        Matcher matcher = pattern.matcher("*");
        System.out.println(strb.matches("[a-zA-Z]+"));

    }


}
