package com.snow.redis.message;

import org.aspectj.weaver.Iterators;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Richard on 2014/12/29.
 */
@Component("messageDelegateListener")
public class MessageDelegateListenerImpl implements MessageDelegateListener {
    @Override
    public void handleMessage(Serializable message) {
        if(message == null){
            System.out.println("null");
        } else if(message.getClass().isArray()){
            System.out.println(Arrays.toString((Object[]) message));
        } else if(message instanceof List<?>) {
            System.out.println(message);
        } else if(message instanceof Map<? , ?>) {
            System.out.println(message);
        } else {
//            System.out.println(ToStringBuilder.reflectionToString(message));
            System.out.println(message);
        }
    }
}
