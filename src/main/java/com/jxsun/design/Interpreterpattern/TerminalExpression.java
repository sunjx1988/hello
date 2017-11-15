package com.jxsun.design.Interpreterpattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}
