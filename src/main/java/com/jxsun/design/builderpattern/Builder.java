package com.jxsun.design.builderpattern;

/**
 * Created by sunjx on 2017/11/7.
 */
public abstract class Builder {

    public abstract Product build();

    public abstract void setPart(String type , String name);
}
