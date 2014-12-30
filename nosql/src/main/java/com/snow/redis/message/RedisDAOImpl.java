package com.snow.redis.message;

import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 * Created by Richard on 2014/12/29.
 */
public class RedisDAOImpl implements RedisDao {

    private RedisTemplate<String, Object> redisTemplate = null;

    public RedisDAOImpl() {

    }
    @Override
    public void sendMessage(String channel, Serializable message) {
        redisTemplate.convertAndSend(channel, message);
    }
}
