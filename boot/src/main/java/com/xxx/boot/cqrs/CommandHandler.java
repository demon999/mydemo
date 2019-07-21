package com.xxx.boot.cqrs;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-07-21 14:11
 */
public interface CommandHandler {
    void handle(Command command);
}
