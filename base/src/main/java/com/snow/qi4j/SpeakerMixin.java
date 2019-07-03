package com.snow.qi4j;

/**
 * Created by richard.xue on 14-8-5.
 */
public class SpeakerMixin implements Speaker {
    @Override
    public String sayHello() {
        return "hello world!";
    }
}
