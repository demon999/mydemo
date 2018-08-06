package com.snow.reflect;

public class MyInterfaceImpl implements MyInterface {
    @Override
    public void say(String content) {
        System.out.println("hello " + content);
    }
}
