package com.pazz.java.core.datatype;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: 彭坚
 * @create: 2018/12/12 15:50
 * @description:
 */
public class StringTest {

    public static void main(String[] args) {
        String strA = "湘A88888";
        //  Tests if this string starts with the specified prefix.
        System.out.println(strA.startsWith("湘A")); //测试这个字符串是否以指定的前缀开始。

        String plate = "abc YY dd 66666";
        System.out.println("小写: " + plate.toLowerCase()); //小写
        System.out.println("大写: " + plate.toUpperCase()); //大写
        System.out.println("String.contains():" + plate.contains("YY"));
        System.out.println("StringBuffer.append(): " + new StringBuffer(plate).append("KKK").toString());
        String names = StringUtils.join(Lists.newArrayList("张三", "李四", "王五"), ",");
        System.out.println("split: " + names.split(",")[0]);
        System.out.println("indexOf: " + plate.indexOf("YY"));
    }

}
