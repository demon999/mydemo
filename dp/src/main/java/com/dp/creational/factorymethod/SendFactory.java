package com.dp.creational.factorymethod;

/**
 * Created by Administrator on 14-6-17.
 */
public class SendFactory {
    public MailSender createMailSender() {
        return new MailSender();
    }

    public SMSSender createSMSSender() {
        return new SMSSender();
    }
}
