package com.jxsun.design.strategypattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class Context {

    private Strategy strategy;

    private Parameter parameter;

    public Context(Strategy strategy, Parameter parameter) {
        this.strategy = strategy;
        this.parameter = parameter;
    }

    //更改策略
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        strategy.execute(parameter);
    }
}
