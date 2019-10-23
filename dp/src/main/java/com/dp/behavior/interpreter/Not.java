package com.dp.behavior.interpreter;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 22:06
 */
public class Not extends Expression {
    private Expression exp;
    public Not(Expression exp) {
        this.exp = exp;
    }
    @Override
    public boolean interpret(Context ctx) {
        return !exp.interpret(ctx);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Not) {
            return exp.equals(((Not)obj).exp);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return "(NOT " + exp.toString() + ")";
    }
}
