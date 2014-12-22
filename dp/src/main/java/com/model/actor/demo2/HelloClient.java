package com.model.actor.demo2;

import akka.actor.ActorRef;

/**
 * Created by Richard on 2014/12/22.
 */
public class HelloClient implements Runnable {
    int seq;
    String serviceName;
    HelloClient(int seq, String serviceName) {
        this.seq = seq;
        this.serviceName = serviceName;
    }

    @Override
    public void run() {
//        ActorRef actor = remote().actorFor(serviceName, "10.68.15.113", 9999);
//        String str = "Hello--" + seq;
//        System.out.println("请求-----${str}");
//        Object res = actor.sendRequestReply(str);
//        System.out.println("返回-----${res}");
    }
    public static void main(String[] args) {
        for (int i = 0; i <= 5; i++) {
            Thread thread = new Thread(new HelloClient(i, "hello-service"));
            thread.start();      //同时启动5个客户端请求Master
        }
    }
}
