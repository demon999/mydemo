package com.dp.creational.factorymethod;

/**
 * Created by Administrator on 14-6-17.
 */
public class SMSSender implements ISender {

    @Override
    public void send() {
        System.out.println("SMSSender------------>send");
    }
}
