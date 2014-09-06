package com.xxx.mq;

/**
 * Created by Richard on 14-9-6.
 */
public class Client {

    public static void main(final String... args) {
        com.rabbitmq.client.ConnectionFactory factory = new com.rabbitmq.client.ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        System.out.println("------------->localhost");
    }

}
