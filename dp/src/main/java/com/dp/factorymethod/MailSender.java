package com.dp.factorymethod;

/**
 * Created by Administrator on 14-6-17.
 */
public class MailSender implements ISender {

    @Override
    public void send() {
        System.out.println("MailSender------------>send");
    }
}
