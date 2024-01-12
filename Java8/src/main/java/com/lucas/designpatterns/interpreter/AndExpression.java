package com.lucas.designpatterns.interpreter;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-11-08 10:38
 */
public class AndExpression extends Expression {
    private Expression expression1 = null;
    private Expression expression2 = null;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    public boolean interpret(String str) {
        return expression1.interpret(str) && expression2.interpret(str);
    }
}
