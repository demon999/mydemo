package com.dp.structural.flyweight;

/**
 * Created by Administrator on 14-6-25.
 * 享元模式的主要目的是实现对象的共享，即共享池，当系统中对象多的时候可以减少内存的开销，通常与工厂模式一起使用。
 *
 *  http://www.cnblogs.com/java-my-life/archive/2012/04/26/2468499.html
 */
public class Client {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight fly = factory.make(new Character('a'));
        fly.operation("First Call");

        fly = factory.make(new Character('b'));
        fly.operation("Second Call");

        fly = factory.make(new Character('a'));
        fly.operation("Third Call");
    }
}
