package com.model.actor.sample;

import akka.actor.*;
import akka.japi.Function;
import org.jboss.netty.channel.socket.Worker;
import scala.concurrent.duration.Duration;

/**
 * Created by Richard on 2015/1/4.
 */
class Supervisor extends UntypedActor {

    private SupervisorStrategy strategy = new OneForOneStrategy(10, Duration.create("1 minute"), new Function<Throwable, SupervisorStrategy.Directive>() {
        @Override
        public SupervisorStrategy.Directive apply(Throwable t) {
//            if (t instanceof ArithmeticException) return resume();
//            else if (t instanceof NullPointerException) return restart();
//            else return escalate();
            return null;
        }
    });

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

    ActorRef worker = context().actorOf(Props.create(Worker.class));

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Integer) worker.forward(message, getContext());
    }
}
