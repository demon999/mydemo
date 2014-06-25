package com.dp.structural.adapter;

/**
 * Created by Administrator on 14-6-25.
 *  适配器模式的核心思想：
 *      把原有的接口转变成调用者所期望的接口,从而使不同接口的类可以一起工作。
 *   适配器中包含如下3个角色。
 ●源角色Adaptee：需要适配的目标或接口。
 ●目标角色Target：所期望得到的接口。
 ●适配器角色Adapter：适配器类是本模式的核心,用来把源接口转换成目标接口,显然这3者角色之间的交互关系便组成了适配器模式的原型。
 适配器也叫做包装器模式(Wrapper),根据适配对象的不同,又可以将适配器模式分为3种子类型。
 ●类的适配器模式：用于对类进行适配。
 ●对象的适配器模式：用于对对象进行包装。
 ●接口的适配器模式：用于对接口抽象化。
 *
 * http://galo.iteye.com/blog/741590
 */
public class Client {
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.operation2();
    }
}
