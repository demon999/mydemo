package com.dp.behavior.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 21:42
 */
public class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

    public void add(Element element) {
        elements.add(element);
    }

    public void show(Visitor visitor) {
        elements.forEach(element -> element.accept(visitor));
    }
}
