package com.jxsun.design.strategypattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class Parameter {

    private int num1;

    private int num2;

    public Parameter(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}
