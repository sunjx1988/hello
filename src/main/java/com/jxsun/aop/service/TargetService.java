package com.jxsun.aop.service;

/**
 * Created by sunjx on 2017/11/29.
 */
public class TargetService {

    public void doSomeThing(){
        System.out.println("service do something");
    }

    public void throwMethod() {
        System.out.println("service throw method");
        throw new RuntimeException();
    }

}
