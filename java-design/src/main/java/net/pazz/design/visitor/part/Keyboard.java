package net.pazz.design.visitor.part;

import net.pazz.design.visitor.ComputerPart;
import net.pazz.design.visitor.ComputerPartVisitor;

/**
 * @author pazz
 * @create 2018/1/23
 * @apiNote Keyboard 键盘
 */
public class Keyboard implements ComputerPart {

    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
