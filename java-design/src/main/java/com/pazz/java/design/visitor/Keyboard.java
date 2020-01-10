package com.pazz.java.design.visitor;

import com.pazz.java.design.visitor.ComputerPart;
import com.pazz.java.design.visitor.ComputerPartVisitor;

/**
 * @author pazz
 * @create 2018/1/23
 * @apiNote Keyboard 键盘
 */
public class Keyboard implements ComputerPart {

    @Override
    public String getName() {
        return "键盘";
    }

    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }

}
