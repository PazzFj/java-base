package com.pazz.java.design.strategy.operation;

import com.pazz.java.design.strategy.Strategy;

/**
 * @author: 彭坚
 * @create: 2019/1/3 15:03
 * @description: 策略模式：乘法操纵
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
