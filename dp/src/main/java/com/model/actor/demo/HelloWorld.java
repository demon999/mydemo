package com.model.actor.demo;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by Richard on 2014/12/22.
 */
public class HelloWorld extends UntypedActor {

    @Override
    public void preStart() {
        final ActorRef greeter = getContext().actorOf(Props.create(Greeter.class), "greeter");
        greeter.tell(Greeter.Msg.GREET, getSelf());
    }

    @Override
    public void onReceive(Object msg) {
        if (msg == Greeter.Msg.DONE) {
            getContext().stop(getSelf());
        } else {
            unhandled(msg);
        }
    }
}
