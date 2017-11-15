package com.jxsun.design.bridgepattern;

/**
 * Created by sunjx on 2017/11/8.
 */
public abstract class Bridge {

    protected Draw draw;

    protected Bridge(Draw draw){
        this.draw = draw;
    }

    public abstract void option();
}
