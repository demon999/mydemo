package com.dp.creational.abstractfactory;

/**
 * Created by Administrator on 14-6-17.
 */
public class Test {
    public static void main(String[] args) {
        IFactory mailFactory = new MailFactory();

        ISender mailSender = mailFactory.createSender();
        mailSender.send();

        IFactory smsFactory = new SMSFactory();
        ISender smsSender = smsFactory.createSender();
        smsSender.send();
    }
}
