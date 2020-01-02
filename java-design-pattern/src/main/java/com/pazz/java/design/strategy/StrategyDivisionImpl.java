package com.pazz.java.design.strategy;

/**
 * @author: 彭坚
 * @create: 2020/1/2 22:50
 * @description: 策略模式: 除法
 */
public class StrategyDivisionImpl implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 / num2;
    }

}
