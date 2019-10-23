package com.dp.behavior.mediator;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 21:09
 */

/**
 * 同事类的抽象父类
 */
public abstract class Colleague {
    /**
     * 持有中介者对象，每一个同事类都知道它的中介者对象
     */
    private Mediator mediator;

    private String name;

    /**
     * 构造方法，传入中介者对象
     *
     * @param mediator 中介者对象
     */
    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    /**
     * 获取当前同事类对应的中介者对象
     *
     * @return 对应的中介者对象
     */
    public Mediator getMediator() {
        return mediator;
    }

    public String getName() {
        return name;
    }

    public abstract void someOperation();
}
