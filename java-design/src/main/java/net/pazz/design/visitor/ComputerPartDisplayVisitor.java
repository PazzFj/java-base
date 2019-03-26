package net.pazz.design.visitor;

import net.pazz.design.visitor.part.Computer;
import net.pazz.design.visitor.part.Keyboard;
import net.pazz.design.visitor.part.Monitor;
import net.pazz.design.visitor.part.Mouse;

/**
 * @author pazz
 * @create 2018/1/23
 * @apiNote 电脑零件展出来访者
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}
