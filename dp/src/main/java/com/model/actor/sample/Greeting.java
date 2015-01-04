package com.model.actor.sample;

import java.io.Serializable;

/**
 * Created by Richard on 2015/1/4.
 */
public class Greeting implements Serializable {
    public final String who;

    public Greeting(String who) {
        this.who = who;
    }
}
