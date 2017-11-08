package com.jxsun.design.adapterpattern;

/**
 * Created by sunjx on 2017/11/8.
 */
public class Run {
    public static void main(String[] args) {
        //类适配器
        Target target = new ClazAdapter();
        target.option1();
        target.option2();

        //对象适配器
        Adaptee adaptee = new Adaptee();
        Target target1 = new ObjectAdapter(adaptee);
        target1.option1();
        target1.option2();
    }
}
