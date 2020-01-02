package com.pazz.java.design.strategy;


/**
 * @author: 彭坚
 * @create: 2019/1/3 15:01
 * @description: 策略模式: 加法
 */
public class StrategyAddImpl implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }

}
