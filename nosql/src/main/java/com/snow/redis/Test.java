package com.snow.redis;

import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Richard on 14-8-25.
 */
public class Test {
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(100);
        config.setMinIdle(100);
        config.setMaxWaitMillis(100000);
    }
}
