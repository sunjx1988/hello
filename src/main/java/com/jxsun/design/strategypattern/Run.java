package com.jxsun.design.strategypattern;

/**
 * Created by sunjx on 2017/11/15.
 * 策略模式
 * 在策略模式中，可以在运行时更改类行为或其算法。 这种类型的设计模式属于行为模式。
 在策略模式中，创建表示各种策略对象和其行为根据其策略对象而变化的上下文对象。 策略对象更改上下文对象的执行算法。
 */
public class Run {
    public static void main(String[] args) {
        Strategy addStrategy = new AddStrategy();
        Strategy multiStrategy = new MultiStrategy();
        Context context = new Context(addStrategy,new Parameter(1,2));
        //执行默认策略
        context.execute();

        //修改策略后执行
        context.setStrategy(multiStrategy);
        context.execute();
    }
}
