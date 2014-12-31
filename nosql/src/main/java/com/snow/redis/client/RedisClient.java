package com.snow.redis.client;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by Richard on 2014/12/30.
 */
@Component("redisClient")
public class RedisClient extends AbstractBaseRedis {

    private String charset = "utf-8";

    @Inject
    private RedisTemplate<String, Object> redisTemplate;

    public void set(final String key,final Object value) {
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//                connection.setNX(key.getBytes(charset),value.toString().getBytes(charset));
                return false;
            }
        });
    }
}
