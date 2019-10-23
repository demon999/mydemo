package com.dp.behavior.mediator.example;

import java.util.Date;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 18:50
 */
public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString() + " [" + user.getName() +"] : " + message);
    }
}
