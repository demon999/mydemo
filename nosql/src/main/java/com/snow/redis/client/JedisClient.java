package com.snow.redis.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.inject.Inject;

/**
 * Created by Richard on 2015/3/13.
 */
@Component
public final class JedisClient {
    private Logger logger = LoggerFactory.getLogger(JedisClient.class);
    @Inject
    private ShardedJedisPool shardedJedisPool;

    private ShardedJedis shardedJedis = null;

    /**
     * 向redis存入key和value,并释放连接资源
     * @param key
     * @param value
     * @return
     */
    public String set(String key,String value) {
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.set(key,value);
        } catch (Exception e) {
            if (shardedJedis != null) {
                shardedJedisPool.returnBrokenResource(shardedJedis);
                shardedJedis = null;
            }
            throw e;
        } finally {
            if (shardedJedis != null) {
                shardedJedisPool.returnResource(shardedJedis);
            }
        }
    }

    /**
     * 通过key获取储存在redis中的value
     * @param key
     * @return
     */
    public String get(String key) {
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.get(key);
        } catch (Exception e) {
            if (shardedJedis != null) {
                shardedJedisPool.returnBrokenResource(shardedJedis);
                shardedJedis = null;
            }
            throw e;
        } finally {
            if (shardedJedis != null) {
                shardedJedisPool.returnResource(shardedJedis);
            }
        }
    }

}
