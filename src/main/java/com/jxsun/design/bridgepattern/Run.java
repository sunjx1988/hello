package com.jxsun.design.bridgepattern;

/**
 * Created by sunjx on 2017/11/8.
 */
public class Run {
    public static void main(String[] args) {
        Draw draw = new DrawCircle();
        Bridge bridge = new BridgeImpl(draw);
        bridge.option();
    }
}
