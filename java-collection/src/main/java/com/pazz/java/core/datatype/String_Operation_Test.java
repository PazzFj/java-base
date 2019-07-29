package com.pazz.java.core.datatype;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/12 15:50
 * @description:
 */
public class String_Operation_Test {

    public static void main(String[] args) {
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
    }

}
