package net.pazz.design.strategy.pattern;

import net.pazz.design.strategy.Strategy;

/**
 * @author: Peng Jian
 * @date: 2018/5/30 9:39
 * @description: FirstStrategy  第一策略 (+)
 */
public class FirstStrategy implements Strategy {
    @Override
    public void execute(int sum1, int sum2) {
        System.out.println("Called FirstStrategy.execute() sum1 + sum2 = " + (sum1 + sum2));
    }
}
