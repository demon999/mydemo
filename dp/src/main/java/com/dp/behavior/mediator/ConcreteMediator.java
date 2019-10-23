package com.dp.behavior.mediator;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 21:11
 */
/**
 * 具体的中介者实现
 */
public class ConcreteMediator implements Mediator {

    @Override
    public void changed(Colleague colleague, String message) {
        //某个同事类发生了变化，通常需要与其他同事交互
        //具体协调相应的同事对象来实现协作行为

        System.out.println(colleague.getName() + " >>> " + message);
    }

}
