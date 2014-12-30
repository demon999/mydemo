package com.snow.redis.message;

import java.io.Serializable;

/**
 * Created by Richard on 2014/12/29.
 */
public interface MessageDelegateListener {
    public void handleMessage(Serializable message);
}
