package com.dp.behavior.command;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 17:15
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.execute();
    }
}
