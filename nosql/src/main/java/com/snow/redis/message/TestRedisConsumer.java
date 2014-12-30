package com.snow.redis.message;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Richard on 2014/12/29.
 */
public class TestRedisConsumer {

    private MessageDelegateListenerImpl messageDelegateListener=null;

    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-redis.xml");
        messageDelegateListener = (MessageDelegateListenerImpl) applicationContext.getBean("messageDelegateListener");
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-redis.xml");
        System.out.println("消费者1");
        while (true) { //这里是一个死循环,目的就是让进程不退出,用于接收发布的消息
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
