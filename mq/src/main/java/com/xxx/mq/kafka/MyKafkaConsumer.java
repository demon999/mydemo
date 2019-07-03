package com.xxx.mq.kafka;


import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.*;

/**
 * Created by richard.xue on 9/7/14.
 */
public class MyKafkaConsumer extends Thread {
    private final Consumer<Integer, String> kafkaConsumer;
    private final String topic;

    public MyKafkaConsumer(String topic) {
        kafkaConsumer = new KafkaConsumer<>(buildKafkaProperty());
        this.topic = topic;
        kafkaConsumer.subscribe(Arrays.asList(topic));
    }

    private static Properties buildKafkaProperty() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", KafkaProperties.brokers);
        properties.put("group.id", KafkaProperties.groupId);
        properties.put("enable.auto.commit", "false"); // 是否自动确认offset
//        properties.put("auto.commit.interval.ms", "1000"); // 自动确认时间
        properties.put("session.timeout.ms", "30000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return properties;
    }

    @Override
    public void run() {
        List<ConsumerRecord<Integer, String>> buffer = new ArrayList<>();
        final int minBatchSize = 200;

        while (true) {
            ConsumerRecords<Integer, String> consumerRecords = kafkaConsumer.poll(1000L);
            for (ConsumerRecord<Integer, String> item : consumerRecords) {
                System.out.println("Consumer Message: " + item.value() + ",Partition:" + item.partition() + " Offset:"
                        + item.offset());
            }

            for (ConsumerRecord<Integer, String> record : consumerRecords) {
                buffer.add(record);
            }
            /* 数据达到批量要求，就写入DB，同步确认offset */
            if (buffer.size() >= minBatchSize) {
//                insertIntoDb(buffer);
                kafkaConsumer.commitSync();
                buffer.clear();
            }

        }

    }

}
