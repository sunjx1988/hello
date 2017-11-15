package com.jxsun.design.templatepattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class Cricket extends Game {
    @Override
    void init() {
        System.out.println("init Cricket");
    }

    @Override
    void start() {
        System.out.println("start Cricket");
    }

    @Override
    void end() {
        System.out.println("end Cricket");
    }
}
