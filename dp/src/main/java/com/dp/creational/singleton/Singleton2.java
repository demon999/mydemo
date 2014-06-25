package com.dp.creational.singleton;

/**
 * Created by Administrator on 14-6-17.
 */
public class Singleton2 {
    private Singleton2 (){}

    private static class SingetonInner {
        private static Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return SingetonInner.instance;
    }
}
