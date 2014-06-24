package com.dp.builder;

/**
 * Created by Administrator on 14-6-24.
 */
public interface CarBuilder {
    public void buildWheel();
    public void buildEngine();
    public void buildShell();
    public Car getCar();
}
