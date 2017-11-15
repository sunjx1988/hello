package com.jxsun.design.Interpreterpattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class AndExpression implements Expression {
    private Expression expression1;

    private Expression expression2;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) && expression2.interpret(context);
    }
}
