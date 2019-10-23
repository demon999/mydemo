package com.dp.behavior.mediator.example;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 18:50
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
