package com.jxsun.design.visitorpattern;

/**
 * Created by sunjx on 2017/11/16.
 * 在访问者模式中，使用访问者类来改变元素类的执行算法。 通过这种方式，元素的执行算法可以随访问者变化而变化。
 * 此模式属于行为模式类别。 根据每个模式，元素对象必须接受访问者对象，以便访问者对象处理对元素对象的操作。
 */
public class Run {
    public static void main(String[] args) {
        ComputerVisitor  visitor = new ComputerDisplayVisitor();
        ComputerPart[] computerParts = new ComputerPart[3];
        Computer computer = new Computer(computerParts);

        computerParts[0] = new Monitor();
        computerParts[1] = new KeyBoard();
        computerParts[2] = new Mouse();

        computer.accept(visitor);
    }
}
