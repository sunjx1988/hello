package com.jxsun.design.mementopattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class Originator {

    private String state;

    public Originator(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveToMemento(){
        return new Memento(this.state);
    }

    public void getFromMemento(Memento memento){
        this.setState(memento.getState());
    }
}
