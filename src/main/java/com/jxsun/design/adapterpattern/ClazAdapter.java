package com.jxsun.design.adapterpattern;

/**
 * Created by sunjx on 2017/11/8.
 * 这种属于类适配
 */
public class ClazAdapter extends Adaptee implements Target {

    @Override
    public void option1() {
        super.option1();
    }

    @Override
    public void option2() {
        System.out.println("ClazAdapter option1...");
    }
}
