package net.pazz.base.datatype;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Peng Jian
 * @date: 2018/6/5 13:43
 * @description: String
 */
public class StringType {

    public static void main(String[] args) {
        /**
         * char 类型 只能占一个位置 无论汉字还是字母 (二个字节)
         *  char ca = 'A';
         *  char cb = '汉';
         *  int cd = cb + cc;
         *  char ce = 'a' + 'b';
         */
        StringBuffer stringBuffer = new StringBuffer();
        String str = new String();
        System.out.println("_" + stringBuffer + "_");
        System.out.println("_" + str + "_");


        String strA = "Aa";
        //  Tests if this string starts with the specified prefix.
        System.out.println(strA.startsWith("A")); //测试这个字符串是否以指定的前缀开始。

        String plate = "湘C k6666";
        System.out.println(plate.toUpperCase()); //大写
        System.out.println(plate.toLowerCase()); //小写

        testStringTime();
        testStringList();
//        StopWatch stopWatch = new StopWatch();   // spring  jar
//        stopWatch.start();
//        stopWatch.stop();
//        System.out.println(stopWatch.getLastTaskTimeMillis());
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

    public static void testStringList(){
        List<String> list = new ArrayList<>();
        list.add("pj");
        list.add("it");
        String s = StringUtils.join(list, ",");
        System.out.println(s);
    }

}
