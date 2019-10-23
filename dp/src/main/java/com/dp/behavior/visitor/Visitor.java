package com.dp.behavior.visitor;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 21:35
 */
public interface Visitor {
    void visit(ElementA elementA);
    void visit(ElementB elementB);
}
