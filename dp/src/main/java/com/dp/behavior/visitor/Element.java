package com.dp.behavior.visitor;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 21:36
 */
public interface Element {
    void accept(Visitor visitor);
}
