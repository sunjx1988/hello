package com.jxsun.design.templatepattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public abstract class Game {

    abstract void init();

    abstract void start();

    abstract void end();

    public final void play(){
        init();
        start();
        end();
    }
}
