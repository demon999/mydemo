package com.snow.redis.message;

import java.io.Serializable;

/**
 * @author Richard Xue
 * @date 05/16/2015
 * @description
 */
public interface RedisDao {
    public void sendMessage(String channel, Serializable message);
}
