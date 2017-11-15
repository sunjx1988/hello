package com.jxsun.design.observerpattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class HexaObserver extends Observer {
    public HexaObserver(Subject subject) {
        super(subject);
        subject.addObserver(this);
    }

    @Override
    void update() {
        System.out.println("HexaObserver:" + subject.getState());
    }
}
