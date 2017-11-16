package com.jxsun.design.visitorpattern;

/**
 * Created by sunjx on 2017/11/16.
 */
public class Computer implements ComputerPart {
    private ComputerPart[] computerParts;

    public Computer(ComputerPart[] computerParts) {
        this.computerParts = computerParts;
    }

    @Override
    public void accept(ComputerVisitor visitor) {
        for (int i = 0; i < computerParts.length; i++) {
            computerParts[i].accept(visitor);
        }

        visitor.visit(this);
    }
}
