package com.jxsun.design.mementopattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjx on 2017/11/15.
 */
public class CareTaker {

    private List<Memento> list = new ArrayList<>();

    public void addMemento(Memento memento){
        this.list.add(memento);
    }

    public Memento getMemento(int index){
        return this.list.get(index);
    }
}
