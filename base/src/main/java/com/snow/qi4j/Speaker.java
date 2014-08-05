package com.snow.qi4j;

import org.qi4j.api.mixin.Mixins;

/**
 * Created by xueliming on 14-8-5.
 */
@Mixins(SpeakerMixin.class )
public interface Speaker {
    String sayHello();
}
