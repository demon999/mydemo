package com.model.actor.demo;

import akka.actor.UntypedActor;

/**
 * Created by Richard on 2014/12/22.
 */
public class Greeter extends UntypedActor {

    public static enum Msg {
        GREET, DONE
    }

    @Override
    public void onReceive(Object msg) {
        if (msg == Msg.GREET) {
            System.out.println("Hello World!");
            getSender().tell(Msg.DONE, getSelf());
        } else {
            unhandled(msg);
        }
    }
}
