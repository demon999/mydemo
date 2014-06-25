package com.dp.structural.decorator;

/**
 * Created by Administrator on 14-6-25.
 */
public class Manager implements Person {
    private Person person;

    public Manager(Person person) {
        this.person = person;
    }

    @Override
    public void doCoding() {
        System.out.println("Manager---->before doCoding");
        person.doCoding();
    }
}
