package com.jxsun.design.Interpreterpattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class OrExpression implements Expression {

    private Expression exp1;
    private Expression exp2;

    public OrExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public boolean interpret(String context) {
        return exp1.interpret(context) || exp2.interpret(context);
    }
}
