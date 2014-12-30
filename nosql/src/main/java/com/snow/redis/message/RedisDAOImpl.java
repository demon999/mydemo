package com.snow.redis.message;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by Richard on 2014/12/29.
 */
@Component("redisDao")
public class RedisDAOImpl implements RedisDao {

    @Inject
    private RedisTemplate<String, Object> redisTemplate = null;

    public RedisDAOImpl() {

    }
    @Override
    public void sendMessage(String channel, Serializable message) {
        redisTemplate.convertAndSend(channel, message);
    }
}
