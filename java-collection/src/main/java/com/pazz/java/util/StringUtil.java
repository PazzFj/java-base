package com.pazz.java.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;

/**
 * @author: 彭坚
 * @create: 2018/9/6 9:44
 * @description: 字符工具类
 */
public final class StringUtil extends org.apache.commons.lang3.StringUtils {

    /**
     * 功能描述: example ==> String.format("param1 = %s param2 = %x", "pengjian", 22)
     *
     * @author 彭坚
     * @date 2018/9/10 23:27
     * @since V1.0.0
     */
    public static String format(String str, Object... objects) {
        String newStr = String.format(str, objects);
        return newStr;
    }

    /**
     * 功能描述: example ==> MessageFormat.format("name = {0}   age = {1} ", "zs", 22)
     *
     * @author 彭坚
     * @date 2018/9/10 23:29
     * @since V1.0.0
     */
    public static String format1(String str, Object... objects){
        String newStr = MessageFormat.format(str, objects);
        return newStr;
    }

    /**
     * 功能描述: enc ==> utf-8 or GBK
     *
     * @author 彭坚
     * @date 2018/9/10 23:26
     * @since V1.0.0
     */
    public static String encode(String s, String enc){
        try {
            String str = URLEncoder.encode(s, enc);
            return str;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
