package com.jxsun.design.visitorpattern;

/**
 * Created by sunjx on 2017/11/16.
 */
public class ComputerDisplayVisitor implements ComputerVisitor {
    @Override
    public void visit(Computer computer) {
        System.out.println("visit computer");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("visit mouse");
    }

    @Override
    public void visit(KeyBoard keyBoard) {
        System.out.println("visit keyBoard");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("visit monitor");
    }
}
