package com.pazz.java.design.visitor;

import com.pazz.java.design.visitor.part.Computer;
import com.pazz.java.design.visitor.part.Keyboard;
import com.pazz.java.design.visitor.part.Monitor;
import com.pazz.java.design.visitor.part.Mouse;

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
