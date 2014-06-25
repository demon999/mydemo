package com.dp.creational.abstractfactory;

/**
 * Created by Administrator on 14-6-17.
 */
public class SMSFactory implements IFactory {

    @Override
    public ISender createSender() {
        return new SMSSender();
    }
}
