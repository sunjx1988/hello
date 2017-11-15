package com.jxsun.design.strategypattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class AddStrategy implements Strategy{
    @Override
    public void execute(Parameter parameter) {
        System.out.println("AddStrategy execute result : " + (parameter.getNum1() + parameter.getNum2()));
    }

}
