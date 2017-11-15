package com.jxsun.design.mementopattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
