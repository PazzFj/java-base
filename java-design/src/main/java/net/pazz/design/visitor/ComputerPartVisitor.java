package net.pazz.design.visitor;

import net.pazz.design.visitor.part.Computer;
import net.pazz.design.visitor.part.Keyboard;
import net.pazz.design.visitor.part.Monitor;
import net.pazz.design.visitor.part.Mouse;

/**
 * @author pazz
 * @create 2018/1/23
 * @apiNote ComputerPartVisitor 电脑零件来访者
 */
public interface ComputerPartVisitor {

    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);

}
