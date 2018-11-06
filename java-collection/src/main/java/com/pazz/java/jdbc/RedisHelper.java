package com.pazz.java.jdbc;

import redis.clients.jedis.Jedis;

/**
 * @author: Peng Jian
 * @create: 2018/11/3 15:49
 * @description:
 */
public class RedisHelper {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("120.79.141.169", 6379);
//        jedis.set("name", "Pj");
        String value = jedis.get("name");
        System.out.println(value);
        jedis.close();
    }

}
