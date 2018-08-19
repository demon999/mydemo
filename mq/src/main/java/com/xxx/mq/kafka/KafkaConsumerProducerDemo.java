package com.xxx.mq.kafka;

/**
 * Created by xueliming on 9/7/14.
 */
public class KafkaConsumerProducerDemo {
    public static void main(String[] args) {
        MyKafkaProducer producerThread = new MyKafkaProducer(KafkaProperties.topic);
        producerThread.start();

//        MyKafkaConsumer consumerThread = new MyKafkaConsumer(KafkaProperties.topic);
//        consumerThread.start();
    }
}
