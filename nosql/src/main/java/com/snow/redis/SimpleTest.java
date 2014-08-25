package com.snow.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by Richard on 14-8-25.
 */
public class SimpleTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
    }
}
