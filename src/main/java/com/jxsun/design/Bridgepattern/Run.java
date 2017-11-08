package com.jxsun.design.Bridgepattern;

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
