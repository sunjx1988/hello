package com.jxsun.design.templatepattern;

/**
 * Created by sunjx on 2017/11/15.
 */
public class Run {
    public static void main(String[] args) {
        Game footBall = new FootBall();
        Game cricket = new Cricket();

        footBall.play();
        cricket.play();
    }
}
