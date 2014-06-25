package com.dp.structural.facade;

/**
 * Created by Administrator on 14-6-24.
 */
public class Computer {
    private CPU cpu;
    private Memory memory;

    public Computer(){
        cpu = new CPU();
        memory = new Memory();
    }

    public void startup(){
        System.out.println("start the computer!");
        cpu.startup();
        memory.startup();
        System.out.println("start computer finished!");
    }

    public void shutdown(){
        System.out.println("begin to close the computer!");
        cpu.shutdown();
        memory.shutdown();
        System.out.println("computer closed!");
    }
}
