package com.pazz.java.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author: Peng Jian
 * @create: 2018/11/3 15:55
 * @description: redis 工具类
 */
public class RedisUtil {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    // redis 使用池
    private static Map<String, JedisPool> poolMap = new HashMap<>();

    private RedisUtil() {
    }

    // 单例
    public static RedisUtil getInstance() {
        return RedisHolder.INSTANCE;
    }

    private static JedisPool getPool(String ip, int port) {
        String key = key(ip, port);
        if (!poolMap.containsKey(key)) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(RedisConfig.MAX_IDLE);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);
            JedisPool pool = new JedisPool(config, ip, port);
            poolMap.put(key, pool);
            return pool;
        }
        return poolMap.get(key);
    }

    private static String key(String ip, int port) {
        String key = ip + "#" + port;
        return key;
    }

    // 从连接处获取redis
    public Jedis getJedis(String ip, int port) {
        Jedis jedis = null;
        int count = 0;
        do {
            try {
                jedis = getPool(ip, port).getResource();
            } catch (Exception e) {
                logger.info("get redis master failed!");
            }
        }
        while (jedis == null && count < RedisConfig.RETRY_NUM);
        return jedis;
    }

    public void closeJedis(Jedis jedis, String ip, int port) {
        if (jedis != null) {
            jedis.close();
            getPool(ip, port).close();
        }
    }

    private static class RedisHolder {
        private static final RedisUtil INSTANCE = new RedisUtil();
    }

}
