package com.dp.behavior.visitor;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 21:37
 */
public class ElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
