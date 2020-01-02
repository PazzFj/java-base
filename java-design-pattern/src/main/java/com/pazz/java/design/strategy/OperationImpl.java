package com.pazz.java.design.strategy;

/**
 * @author: 彭坚
 * @create: 2019/1/3 15:05
 * @description: 具体操作类
 */
public class OperationImpl {

    private Strategy strategy;

    public OperationImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
