package com.pazz.java.database.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author: Peng Jian
 * @create: 2018/11/3 15:55
 * @description:
 */
public class Redis_Helper {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Redis_Helper() {
    }

    private static class RedisUtilHolder {
        private static final Redis_Helper instance = new Redis_Helper();
    }

    public static Redis_Helper getInstance() {
        return RedisUtilHolder.instance;
    }

    private static Map<String, JedisPool> poolMap = new HashMap<>();

    private static JedisPool getPool(String ip, int port) {
        String key = ip + ":" + port;
        JedisPool pool = null;
        if (!poolMap.containsKey(key)) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(RedisConfig.MAX_IDLE);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);
            pool = new JedisPool(config, ip, port);
            poolMap.put(key, pool);
        } else {
            pool = poolMap.get(key);
        }
        return pool;
    }

    public Jedis getJedis(String ip, int port) {
        Jedis jedis = null;
        int count = 0;
        do {
            try {
                jedis = getPool(ip, port).getResource();
            } catch (Exception e) {
                logger.info("get redis master1 failed!");
//                getPool(ip, port).returnBrokenResource(jedis);
            }
        }
        while (jedis == null && count < RedisConfig.RETRY_NUM);
        return jedis;
    }

    public void closeJedis(Jedis jedis, String ip, int port) {
        if (jedis != null) {
            jedis.close();
            getPool(ip, port).close();
//            getPool(ip, port).returnResource(jedis);
        }
    }

}
