package com.pazz.java.design.interpreter;

/**
 * 终端  表达式
 *
 * @author pazz
 * @create 2018/1/30
 */
public class ExpressionContainsImpl implements Expression {

    private String data;

    public ExpressionContainsImpl(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }

}
