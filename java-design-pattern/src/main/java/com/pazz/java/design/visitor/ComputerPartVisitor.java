package com.pazz.java.design.visitor;

/**
 * @author pazz
 * @create 2018/1/23
 * @apiNote ComputerPartVisitor 电脑零件组装
 */
public interface ComputerPartVisitor {

    // 组装
    void visit(ComputerPart computerPart);

}
