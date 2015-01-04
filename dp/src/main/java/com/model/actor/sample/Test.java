package com.model.actor.sample;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Created by Richard on 2015/1/4.
 */
public class Test {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("MySystem");
        ActorRef greeter = system.actorOf(Props.create(GreetingActor.class), "greeter");
        greeter.tell(new Greeting("Charlie Parker"), ActorRef.noSender());

//        // ------------------------------
//        // on machine 1: empty system, target for deployment from machine 2
//        ActorSystem system = ActorSystem.create("MySystem");
//
//        // ------------------------------
//        // on machine 2: Remote Deployment - deploying on machine1
//        ActorSystem system = ActorSystem.create("MySystem");
//        ActorRef greeter = system.actorOf(Props.create(GreetingActor.class), "greeter");
//
//        // ------------------------------
//        // on machine 3: Remote Lookup (logical home of “greeter” is machine2, remote deployment is transparent)
//        ActorSystem system = ActorSystem.create("MySystem");
//        ActorSelection greeter = system.actorSelection("akka.tcp://MySystem@machine2:2552/user/greeter");
//        greeter.tell(new Greeting("Sonny Rollins"), ActorRef.noSender());
    }
}
