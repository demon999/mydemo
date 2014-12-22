package com.model.actor.demo;

import akka.actor.UntypedActor;

/**
 * Created by Richard on 2014/12/22.
 */
public class HelloWorldActor extends UntypedActor {
    public void onReceive(Object msg) {
//        getContext().reply(msg + " World");
    }
}
