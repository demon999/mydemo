package com.dp.behavior.mediator;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 21:17
 */
public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague colleague = new ConcreteColleague(mediator);
        colleague.someOperation();
    }
}
