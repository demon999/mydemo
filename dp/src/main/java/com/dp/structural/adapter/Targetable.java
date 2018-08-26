package com.dp.structural.adapter;

/**
 * Created by Administrator on 14-6-25.
 * 目标接口Target
 */
public interface Targetable {
    //与源类相同的接口函数
    void operation1();
    //新的接口函数,源类中没有
    void operation2();
}
