package com.pazz.java.design.visitor;

/**
 * @author pazz
 * @create 2018/1/23
 * @note mainframe 主机
 */
public class MainFrame implements ComputerPart {

    private ComputerPart[] computerParts;

    public MainFrame() {
        computerParts = new ComputerPart[]{new Mouse(), new Monitor(), new Keyboard()};
    }

    @Override
    public String getName() {
        return "主机";
    }

    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < computerParts.length; i++) {
            computerParts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }

}
