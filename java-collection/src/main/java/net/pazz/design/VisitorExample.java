package net.pazz.design;

import net.pazz.design.visitor.ComputerPartDisplayVisitor;
import net.pazz.design.visitor.part.Computer;

/**
 * @author pazz
 * @create 2018/1/23
 * @apiNote 访问者模式
 */
public class VisitorExample {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }

}