package com.pazz.java.design.visitor;

import com.pazz.java.design.visitor.ComputerPart;
import com.pazz.java.design.visitor.ComputerPartVisitor;

/**
 * @author pazz
 * @create 2018/1/23
 * @apiNote Mouse 鼠标
 */
public class Mouse implements ComputerPart {

    @Override
    public String getName() {
        return "鼠标";
    }

    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }

}
