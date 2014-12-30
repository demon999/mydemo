package com.snow.redis.message2;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * Created by Richard on 2014/12/30.
 */
public class RedisMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("Message received: " + message.toString());
    }
}
