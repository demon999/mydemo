package com.dp.behavior.interpreter;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 22:04
 */
public class Constant extends Expression {
    private boolean value;
    public Constant(boolean value) {
        this.value = value;
    }
    @Override
    public boolean interpret(Context ctx) {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Constant) {
            return this.value == ((Constant)obj).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }
}
