package com.dp.proxy;

/**
 * Created by Administrator on 14-6-25.
 */
public class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("From real subject.");
    }
}
