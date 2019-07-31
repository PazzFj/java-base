package com.pazz.java.util;

import java.util.UUID;

public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * @auto peng jian
     * @date 2019/7/31 15:45
     * @Description 创建随机字符串
     * @version 1.0
     */
    public static String getShortUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
