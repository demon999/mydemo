package com.dp.behavior.command;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 17:10
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
