package com.snow.redis.message2;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Richard on 2014/12/30.
 */
public class RedisPublisherImpl implements IRedisPublisher {
    private final RedisTemplate<String, Object> template;
    private final ChannelTopic topic;
    private final AtomicLong counter = new AtomicLong(0);

    public RedisPublisherImpl(final RedisTemplate<String, Object> template, final ChannelTopic topic) {
        this.template = template;
        this.topic = topic;
    }

    @Scheduled(fixedDelay = 100)
    public void publish() {
        template.convertAndSend(topic.getTopic(), "Message " + counter.incrementAndGet() + ", " + Thread.currentThread().getName());
    }
}
