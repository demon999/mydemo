package com.snow.redis.message;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Richard on 2014/12/30.
 */
public class TestRedisProducer {
    private RedisDaoImpl redisDao = null;

    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-redis.xml");
        redisDao = (RedisDaoImpl) applicationContext.getBean("redisDao");
    }

    @Test
    public void testPublishMessage() throws Exception {
        String msg = "Hello, Redis!";
        redisDao.sendMessage("java", msg); //发布字符串消息

        Integer[] values = new Integer[]{21341, 123123, 12323};
        redisDao.sendMessage("java", values);  //发布一个数组消息
    }
}
