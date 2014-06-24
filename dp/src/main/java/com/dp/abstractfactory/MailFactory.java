package com.dp.abstractfactory;

/**
 * Created by Administrator on 14-6-17.
 */
public class MailFactory implements IFactory {

    public ISender createSender() {
        return new MailSender();
    }
}
