package com.dp.facade;

/**
 * Created by Administrator on 14-6-24.
 * Facade模式的几个要点
 * • 从客户程序的角度来看， Facade模式不仅简化了整个组件系统的接口，同时对于组件内部与外部客户程序来说，
 *      从某种程度上也达到了一种“解耦”的效果——内部子系统的任何变化不会影响到Façade接口的变化。
 * • Façade设计模式更注重从架构的层次去看整个系统，而不是单个类的层次。Façade很多时候更是一种架构设计模式。
 * • 注意区分Façade模式、Adapter模式、Bridge模式与Decorator模式。Façade模式注重简化接口，Adapter模式注重转换接口，
 *      Bridge模式注重分离接口（抽象）与其实现，Decorator模式注重稳定接口的前提下为对象扩展功能。
 */
public class User {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
