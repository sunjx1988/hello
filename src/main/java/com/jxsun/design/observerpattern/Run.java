package com.jxsun.design.observerpattern;

/**
 * Created by sunjx on 2017/11/15.
 * 观察者模式
 *观察者模式在对象之间存在一对多关系时使用，例如，如果一个对象被修改，它的依赖对象将被自动通知。 观察者模式属于行为模式类别。
 */
public class Run {

    public static void main(String[] args) {
        Subject subject = new Subject("subject state#0");
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        HexaObserver hexaObserver = new HexaObserver(subject);

        Subject subject1 = new Subject("subject1 state#0");
        BinaryObserver binaryObserver1 = new BinaryObserver(subject1);

        subject.setState("subject state#1");
        subject1.setState("subject1 state#1");
    }
}
