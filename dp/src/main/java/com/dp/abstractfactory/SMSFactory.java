package com.dp.abstractfactory;

/**
 * Created by Administrator on 14-6-17.
 */
public class SMSFactory implements IFactory {

    @Override
    public ISender createSender() {
        return new SMSSender();
    }
}
