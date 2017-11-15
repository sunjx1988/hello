package com.jxsun.design.Interpreterpattern;

/**
 * Created by sunjx on 2017/11/15.
 * 解释器模式
 * 解释器模式提供了一种评估计算语言语法或表达式的方法。 这种类型的模式属于行为模式。 这种模式涉及实现一个表达式接口，它告诉解释一个指定的上下文。 此模式用于SQL解析，符号处理引擎等。
 */
public class Run {

    //Rule: Robert and John are male
    private static Expression getMaleExpression(){
        return new OrExpression(new TerminalExpression("Robert") , new TerminalExpression("John"));
    }

    //Rule: Julie is a married women
    private static Expression getMarriedWomanExpression(){
        return new AndExpression(new TerminalExpression("Julie") , new TerminalExpression("Married"));
    }

    public static void main(String[] args) {
        Expression maleExpression = getMaleExpression();
        Expression marriedWomanExpression = getMarriedWomanExpression();

        System.out.println("John is male? " + maleExpression.interpret("John"));
        System.out.println("Julie is a married women? " + marriedWomanExpression.interpret("Married Julie"));
    }
}
