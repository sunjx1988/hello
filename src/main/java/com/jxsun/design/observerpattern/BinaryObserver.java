package com.jxsun.design.observerpattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
        subject.addObserver(this);
    }

    @Override
    void update() {
        System.out.println("BinaryObserver:" + subject.getState());
    }
}
