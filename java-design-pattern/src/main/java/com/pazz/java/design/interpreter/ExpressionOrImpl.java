package com.pazz.java.design.interpreter;

/**
 * 或
 *
 * @author pazz
 * @create 2018/1/30
 */
public class ExpressionOrImpl implements Expression {

    private Expression expression1 = null;
    private Expression expression2 = null;

    public ExpressionOrImpl(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) || expression2.interpret(context);
    }
}
