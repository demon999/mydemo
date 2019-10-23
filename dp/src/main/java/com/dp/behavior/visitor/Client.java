package com.dp.behavior.visitor;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 21:46
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new ElementA());
        objectStructure.add(new ElementB());
        objectStructure.show(new Visitor1());
    }
}
