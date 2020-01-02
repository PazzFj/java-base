package com.pazz.java.design.visitor;

import com.pazz.java.design.visitor.ComputerPart;
import com.pazz.java.design.visitor.ComputerPartVisitor;

/**
 * @author pazz
 * @create 2018/1/23
 * @apiNote Monitor 显示器
 */
public class Monitor implements ComputerPart {

    @Override
    public String getName() {
        return "显示器";
    }

    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }

}
