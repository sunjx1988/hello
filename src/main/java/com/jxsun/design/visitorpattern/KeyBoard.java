package com.jxsun.design.visitorpattern;

/**
 * Created by sunjx on 2017/11/16.
 */
public class KeyBoard implements ComputerPart {
    @Override
    public void accept(ComputerVisitor visitor) {
        visitor.visit(this);
    }
}
