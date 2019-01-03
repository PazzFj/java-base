package com.pazz.java.design.strategy;

/**
 * @author: 彭坚
 * @create: 2019/1/3 15:05
 * @description:
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
