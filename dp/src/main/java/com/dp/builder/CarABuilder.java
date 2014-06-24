package com.dp.builder;

/**
 * Created by Administrator on 14-6-24.
 */
public class CarABuilder implements CarBuilder {
    private Car car = null;
    public CarABuilder() {
        car = new Car();
    }
    @Override
    public void buildWheel() {
        car.setWheel(new CnWheel());
    }

    @Override
    public void buildEngine() {
        car.setEngine(new CnEngine());
    }

    @Override
    public void buildShell() {
        car.setShell(new CnShell());
    }

    @Override
    public Car getCar() {
        buildWheel();
        buildEngine();
        buildShell();
        return car;
    }
}
