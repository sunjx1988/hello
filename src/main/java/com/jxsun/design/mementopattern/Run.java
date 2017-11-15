package com.jxsun.design.mementopattern;

/**
 * Created by sunjx on 2017/11/15.
 * 备忘录模式(Memento Pattern)用来恢复一个对象的状态到以前的状态。
 */
public class Run {

    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Originator originator = new Originator("state#0");

        System.out.println("初始化状态" + originator.getState());

        System.out.println("修改前先保存一下状态");
        careTaker.addMemento(originator.saveToMemento());

        System.out.println("修改状态为#1");
        originator.setState("state#1");

        System.out.println("修改后保存一下状态");
        careTaker.addMemento(originator.saveToMemento());

        System.out.println("当前状态:" + originator.getState());

        System.out.println("还原到初始化的状态：");
        originator.getFromMemento(careTaker.getMemento(0));

        System.out.println("当前状态:" + originator.getState());
    }
}
