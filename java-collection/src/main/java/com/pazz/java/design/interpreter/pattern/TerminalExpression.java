package com.pazz.java.design.interpreter.pattern;

import com.pazz.java.design.interpreter.Expression;

/**
 * @author pazz
 * @create 2018/1/30
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data))
            return true;
        return false;
    }

}
