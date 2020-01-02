package com.pazz.java.design.visitor;

/**
 * @author pazz
 * @create 2018/1/23
 * @note ComputerPart 电脑零件
 */
public interface ComputerPart {

    String getName();

    /**
     * accept 接受
     * @param computerPartVisitor
     */
    void accept(ComputerPartVisitor computerPartVisitor);

}
