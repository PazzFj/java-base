package com.pazz.java.design.visitor;

/**
 * @author: 彭坚
 * @create: 2020/1/2 23:12
 * @description: 访问者模式:
 */
public class $_Main {

    public static void main(String[] args) {
        ComputerPart mainFrame = new MainFrame();
        ComputerPart keyboard = new Keyboard();
        ComputerPart monitor = new Monitor();
        ComputerPart mouse = new Mouse();


        ComputerPartVisitor partVisitor = new ComputerPartDisplayVisitor();
        partVisitor.visit(mainFrame);
        partVisitor.visit(keyboard);
        partVisitor.visit(monitor);
        partVisitor.visit(mouse);
    }

}
