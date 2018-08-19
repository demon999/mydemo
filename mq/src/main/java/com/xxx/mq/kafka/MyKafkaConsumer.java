package com.xxx.mq.kafka;


import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by xueliming on 9/7/14.
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
//        properties.put("zookeeper.connect", KafkaProperties.zkConnect);
//        properties.put("zookeeper.session.timeout.ms", "40000");
//        properties.put("zookeeper.sync.time.ms", "200");

        properties.put("bootstrap.servers", KafkaProperties.brokers);
        properties.put("group.id", KafkaProperties.groupId);
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("enable.auto.commit", "true");
        properties.put("session.timeout.ms", "30000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return properties;
    }

    @Override
    public void run() {
        while (true) {
//            ConsumerRecords<Integer, String> consumerRecords = kafkaConsumer.poll(100L);
//            for (ConsumerRecord<Integer, String> item : consumerRecords) {
////                item.partition();
//                System.out.println("Consumer Message:" + item.value() + ",Partition:" + item.partition() + "Offset:" + item.offset());
//            }
//            Set<TopicPartition> partitions = consumerRecords.partitions();


        }

    }

}
