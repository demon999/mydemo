package com.xxx.boot.cqrs;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-07-21 14:12
 */
public interface Command<T> {
    /**
     * execute
     * @param t
     */
    void execute(T t);
}
