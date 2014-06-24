package com.dp.factorymethod;

/**
 * Created by Administrator on 14-6-17.
 */
public class Test {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();

        ISender mailSender = factory.createMailSender();
        mailSender.send();

        ISender smsSender = factory.createSMSSender();
        smsSender.send();
    }
}
