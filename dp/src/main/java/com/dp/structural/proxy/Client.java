package com.dp.structural.proxy;

/**
 * Created by Administrator on 14-6-25.
 */
public class Client {

    public static void main(String[] args) {
        Subject sub = new ProxySubject();
        sub.request();
    }

}
