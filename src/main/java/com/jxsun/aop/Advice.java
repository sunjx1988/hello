package com.jxsun.aop;

/**
 * Created by sunjx on 2017/11/29.
 */
public class Advice {

    public void doBefore(){
        System.out.println("advice before");
    }

    public void doAfter(){
        System.out.println("advice after");
    }

    public void afterReturnning(Object rt){
        System.out.println("advice do after returnning");
    }

    public void afterThrowing(RuntimeException ex){
        System.out.println("advice after throwing" + ex.getMessage());
    }

    public void around(){
        System.out.println("advice around");
    }
}
