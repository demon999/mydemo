package com.xxx.mq.kafka;

/**
 * Created by richard.xue on 9/7/14.
 */
public class KafkaConsumerDemo {
    public static void main(String[] args) {
        MyKafkaConsumer consumerThread = new MyKafkaConsumer(KafkaProperties.topic);
        consumerThread.start();
    }
}
