package com.xxx.mq.kafka;

public class KafkaProducerDemo {
    public static void main(String[] args) {
        MyKafkaProducer producerThread = new MyKafkaProducer(KafkaProperties.topic);
        producerThread.start();
    }
}
