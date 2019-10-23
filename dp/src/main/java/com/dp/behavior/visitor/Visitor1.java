package com.dp.behavior.visitor;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 21:39
 */
public class Visitor1 implements Visitor {
    @Override
    public void visit(ElementA elementA) {
        System.out.println("visit elementA");
    }

    @Override
    public void visit(ElementB elementB) {
        System.out.println("visit elementB");
    }
}
