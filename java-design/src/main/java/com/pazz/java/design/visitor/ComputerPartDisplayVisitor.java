package com.pazz.java.design.visitor;

/**
 * @author pazz
 * @create 2018/1/23
 * @apiNote 电脑零件展出来访者
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    public void visit(ComputerPart computerPart) {
        System.out.println("Displaying name." + computerPart.getName());
    }

}
