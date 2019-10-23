package com.dp.behavior.observer;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 17:26
 *
 * 抽象被观察者
 */
public interface Subject {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObserver();
}
