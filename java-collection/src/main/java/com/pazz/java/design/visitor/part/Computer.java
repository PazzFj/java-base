package com.pazz.java.design.visitor.part;

import com.pazz.java.design.visitor.*;

/**
 * @author pazz
 * @create 2018/1/23
 * @note computer 电脑
 */
public class Computer implements ComputerPart {

    private ComputerPart[] computerParts;

    public Computer() {
        computerParts = new ComputerPart[]{new Mouse(), new Monitor(), new Keyboard()};
    }

    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < computerParts.length; i++) {
            computerParts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }

}
