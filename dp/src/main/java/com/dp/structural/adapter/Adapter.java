package com.dp.structural.adapter;

/**
 * Created by Administrator on 14-6-25.
 */
public class Adapter extends Source implements Targetable {

    @Override
    public void operation2() {
        System.out.println("适配目标类后的方法operation2");
    }

}
