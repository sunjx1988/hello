package com.jxsun.design.chainpattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public abstract class AbstractLogger {

    public final static int INFO = 0;
    public final static int DEBUG = 1;
    public final static int ERROR = 2;

    private int level;
    private AbstractLogger next;

    public AbstractLogger(int level){
        this.level = level;
    }

    public void log(int level ,String msg){
        if(this.level >= level){
            write(msg);
        }

        if(null != this.next){
            this.next.log(level,msg);
        }
    }

    public void setNext(AbstractLogger next){
        this.next = next;
    }

    //由实现类具体实现
    protected abstract void write(String msg);
}
