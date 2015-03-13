package com.snow.redis;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richard on 14-8-25.
 */
public class Test {
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(100);
        config.setMinIdle(100);
        config.setMaxWaitMillis(100000);

        List<JedisShardInfo> shardInfoList = new ArrayList<JedisShardInfo>();
        JedisShardInfo jedisShardInfo = new JedisShardInfo("127.0.0.1");
        shardInfoList.add(jedisShardInfo);

        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(config,shardInfoList);
        ShardedJedis shardedJedis = shardedJedisPool.getResource();
        shardedJedis.set("aaa","aaa");
    }
}
