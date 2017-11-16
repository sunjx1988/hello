package com.jxsun.design.visitorpattern;

/**
 * Created by sunjx on 2017/11/16.
 */
public interface ComputerPart {
    void accept(ComputerVisitor visitor);
}
