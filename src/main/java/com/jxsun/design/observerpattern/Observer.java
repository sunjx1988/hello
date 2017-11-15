package com.jxsun.design.observerpattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public abstract class Observer {

    protected Subject subject;

    abstract void update();

    private Observer() {
    }

    public Observer(Subject subject) {
        this.subject = subject;
    }
}
