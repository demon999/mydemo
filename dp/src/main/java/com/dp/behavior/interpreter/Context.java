package com.dp.behavior.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 22:04
 */
public class Context {
    private Map<Variable, Boolean> map = new HashMap<>();

    public void assign(Variable var, boolean value) {
        map.put(var, value);
    }

    public boolean lookup(Variable var) throws IllegalArgumentException {
        Boolean value = map.get(var);
        if (value == null) {
            throw new IllegalArgumentException();
        }
        return value;
    }
}
