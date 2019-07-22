package net.pazz.design.interpreter;

/**
 * 解释器模式
 * @author pazz
 * @create 2018/1/30
 */
public interface Expression {

    public boolean interpret(String context);

}
