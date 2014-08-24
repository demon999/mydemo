package com.dp.structural.adapter;

/**
 * Created by Richard on 14-8-22.
 */
public class Adapter2 implements Targetable {

    private Source source = new Source();

    @Override
    public void operation1() {
        source.operation1();
    }

    @Override
    public void operation2() {

    }
}
