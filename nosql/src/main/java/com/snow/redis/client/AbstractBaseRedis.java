package com.snow.redis.client;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.inject.Inject;

/**
 * Created by Richard on 2014/12/30.
 */
public class AbstractBaseRedis<K, V> {

    @Inject
    protected RedisTemplate<K, V> redisTemplate;

    /**
     * 设置redisTemplate
     * @param redisTemplate the redisTemplate to set
     */
    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 获取 RedisSerializer
     * <br>------------------------------<br>
     */
    protected RedisSerializer<String> getRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }
}
