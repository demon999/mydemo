package com.snow.redis.message2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Richard on 2014/12/30.
 */
public class RedisPubSubStarter {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
