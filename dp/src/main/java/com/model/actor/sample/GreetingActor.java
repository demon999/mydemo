package com.model.actor.sample;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by Richard on 2015/1/4.
 */
public class GreetingActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public void onReceive(Object message) throws Exception {
        if (message instanceof Greeting)
            log.info("Hello " + ((Greeting) message).who);
    }
}
