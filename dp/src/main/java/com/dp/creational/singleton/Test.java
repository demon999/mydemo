package com.dp.creational.singleton;

/**
 * Created by Administrator on 14-6-17.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
    }
}
