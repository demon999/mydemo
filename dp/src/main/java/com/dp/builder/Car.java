package com.dp.builder;

/**
 * Created by Administrator on 14-6-24.
 */
public class Car {
    private Engine engine;
    private Wheel wheel;
    private Shell shell;

    public Shell getShell() {
        return shell;
    }

    public void setShell(Shell shell) {
        this.shell = shell;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
