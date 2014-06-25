package com.dp.decorator;

/**
 * Created by Administrator on 14-6-25.
 * 装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Manager(new Employee());
        person.doCoding();
    }
}
