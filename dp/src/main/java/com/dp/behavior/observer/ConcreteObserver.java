package com.dp.behavior.observer;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 17:32
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("ConcreteObserver >>> update");
    }
}
