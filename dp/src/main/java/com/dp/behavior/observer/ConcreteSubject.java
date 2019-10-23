package com.dp.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 17:29
 *
 * 具体被观察者
 */
public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(Observer::update);
    }
}
