package com.jxsun.design.chainpattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String msg) {
        System.out.println("INFO:" + msg);
    }
}
