package com.pazz.java.design.strategy;

/**
 * @author: 彭坚
 * @create: 2020/1/2 22:51
 * @description: 策略模式
 */
public class $_Main {

    public static void main(String[] args) {
        Strategy division = new StrategyDivisionImpl();     // 除
        Strategy add = new StrategyAddImpl();               // 加
        Strategy multiply = new StrategyMultiplyImpl();     // 乘
        Strategy substract = new StrategySubstractImpl();   // 减

        // 只需要改变策略
        OperationImpl operation = new OperationImpl(multiply);
        int result = operation.execute(33, 3);
        System.out.println(result);

    }

}
