package com.dp.behavior.mediator.example;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 18:49
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
