package com.dp.behavior.mediator;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 21:10
 */
public class ConcreteColleague extends Colleague {
    public ConcreteColleague(Mediator mediator) {
        super(mediator, "ConcreteColleague");
    }
    /**
     * 示意方法，执行某些业务功能
     */
    @Override
    public void someOperation() {
        //在需要跟其他同事通信的时候，通知中介者对象
        getMediator().changed(this, "hello");
    }
}
