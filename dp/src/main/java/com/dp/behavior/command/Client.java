package com.dp.behavior.command;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 17:16
 */
public class Client {
    public static void main(String[] args) {
        //构造一个接收者对象
        Receiver receiver = new Receiver();
        //根据接收者对象，构造一个命令者变量，指向具体命令着对象
        Command concreteCommand = new ConcreteCommand(receiver);
        //根据命令者对象，构造一个请求者对象,多态属性
        Invoker invoker = new Invoker(concreteCommand);
        //请求者发出请求行为
        invoker.action();
    }
}
