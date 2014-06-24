package com.dp.singleton;

/**
 * Created by Administrator on 14-6-17.
 */
public class Singleton {

    private volatile static Singleton instance = null;

    private Singleton(){};

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
