package com.pazz.java.design.strategy;

/**
 * @author: 彭坚
 * @create: 2019/1/3 15:03
 * @description: 策略模式：乘法
 */
public class StrategyMultiplyImpl implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }

}
