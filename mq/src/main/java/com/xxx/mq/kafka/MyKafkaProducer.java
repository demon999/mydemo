package com.xxx.mq.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Properties;

/**
 * Created by xueliming on 9/7/14.
 */
public class MyKafkaProducer extends Thread {
    private final Producer<Integer, String> producer;
    private final String topic;

    public MyKafkaProducer(String topic) {
        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaProperties.brokers);
        props.put("client.id", KafkaProperties.clientId);
        props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(props);
        this.topic = topic;
    }

    @Override
    public void run() {

        List<PartitionInfo> partitionInfos = producer.partitionsFor(topic);
        for(final PartitionInfo partitionInfo : partitionInfos) {
            System.out.println(partitionInfo.toString());
        }

        int messageNo = 1;
        while (true) {
            String messageStr = "Message_" + messageNo;
            System.out.println("Send: " + messageStr);
            producer.send(new ProducerRecord<>(topic, messageNo, messageStr), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    System.out.println(metadata.toString());
                }
            });
            messageNo++;
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
