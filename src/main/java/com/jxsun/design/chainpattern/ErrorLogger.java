package com.jxsun.design.chainpattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String msg) {
        System.out.println("ERROR:" + msg);
    }
}
