package com.pazz.java.database.redis;

import redis.clients.jedis.Jedis;

/**
 * @author: Peng Jian
 * @create: 2018/11/3 15:49
 * @description:
 */
public class RedisTest {

    public static void main(String[] args) throws Exception {
//        Jedis jedis = new Jedis("47.98.219.97", 6379);

        Redis_Helper redisHelper = Redis_Helper.getInstance();
        Jedis jedis = redisHelper.getJedis("47.98.219.97", 6379);
        jedis.set("name", "Pj");
        String value = jedis.get("name");
        System.out.println(value);
        jedis.close();
        redisHelper.closeJedis(jedis, "47.98.219.97", 6379);
    }

}
