package com.pazz.java.design.interpreter;

/**
 * 解释器模式
 *
 * @author pazz
 * @create 2018/1/30
 */
public interface Expression {

    boolean interpret(String context);

}
