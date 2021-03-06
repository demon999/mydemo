package com.dp.behavior.interpreter;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 22:06
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        Variable xVariable = new Variable("X");
        Variable yVariable = new Variable("Y");
        Constant constant = new Constant(true);
        context.assign(xVariable, false);
        context.assign(yVariable, true);

        Expression expression = new Or(new And(constant, xVariable), new And(yVariable, new Not(xVariable)));
        System.out.println("X = " + xVariable.interpret(context));
        System.out.println("Y = " + yVariable.interpret(context));
        System.out.println(expression.toString() + " = " + expression.interpret(context));
    }
}
