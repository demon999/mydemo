package com.dp.builder;

/**
 * Created by Administrator on 14-6-24.
 */
public class Test {
    public static void main(String[] args) {
        Car carA,carB;
        CarBuilder builderA = new CarABuilder();
        CarBuilder builderB = new CarBBuilder();
        carA = builderA.getCar();
        carB = builderB.getCar();
        System.out.println("Car A is made by:"+carA.getEngine()+" "+carA.getWheel()+" "+carA.getShell());
        System.out.println("Car B is made by:"+carB.getEngine()+" "+carB.getWheel()+" "+carB.getShell());
    }
}
