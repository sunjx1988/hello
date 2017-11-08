package com.jxsun.design.adapterpattern;

/**
 * Created by sunjx on 2017/11/8.
 * 对象适配器
 */
public class ObjectAdapter implements Target{
    private Adaptee adaptee ;

    public ObjectAdapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void option1() {
        adaptee.option1();
    }

    @Override
    public void option2() {
        System.out.println("ObjectAdapter option2");
    }
}
