package com.model.actor;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 10/08/2015
 * @description
 */
public class MyActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(context().system(), this);
    public MyActor() {
//        receive(ReceiveBuilder.match(String.class, s -> {
//                            log.info("Received String message: {}", s);
//                        }).matchAny(o -> log.info("received unknown message")).build()
//        );
    }

}
