package com.dp.builder;

/**
 * Created by Administrator on 14-6-24.
 */
public class CarBBuilder implements CarBuilder {
    private Car car = null;
    public CarBBuilder() {
        car = new Car();
    }
    @Override
    public void buildWheel() {
        car.setWheel(new UsWheel());
    }

    @Override
    public void buildEngine() {
        car.setEngine(new UsEngine());
    }

    @Override
    public void buildShell() {
        car.setShell(new UsShell());
    }

    @Override
    public Car getCar() {
        buildWheel();
        buildEngine();
        buildShell();
        return car;
    }
}
