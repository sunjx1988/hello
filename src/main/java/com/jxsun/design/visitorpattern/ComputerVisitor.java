package com.jxsun.design.visitorpattern;

/**
 * Created by sunjx on 2017/11/16.
 */
public interface ComputerVisitor {

    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(KeyBoard keyBoard);

    void visit(Monitor monitor);
}
