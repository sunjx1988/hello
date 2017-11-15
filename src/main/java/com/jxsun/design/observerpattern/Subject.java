package com.jxsun.design.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjx on 2017/11/15.
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private String state;

    public Subject(String state) {
        this.state = state;
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    public String getState() {
        return state;
    }

    private void notifyAllObservers(){
        for (Observer observer : observers){
            observer.update();
        }
    }
}
