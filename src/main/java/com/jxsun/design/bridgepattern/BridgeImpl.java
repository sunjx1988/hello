package com.jxsun.design.bridgepattern;

/**
 * Created by sunjx on 2017/11/8.
 */
public class BridgeImpl extends Bridge {

    public BridgeImpl(Draw draw){
        super(draw);
    }

    @Override
    public void option() {
        draw.draw();
    }
}
