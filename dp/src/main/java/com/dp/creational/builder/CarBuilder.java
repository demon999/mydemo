package com.dp.creational.builder;

/**
 * Created by Administrator on 14-6-24.
 */
public interface CarBuilder {
    void buildWheel();

    void buildEngine();

    void buildShell();

    Car getCar();
}
