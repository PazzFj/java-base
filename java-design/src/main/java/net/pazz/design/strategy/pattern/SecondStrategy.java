package net.pazz.design.strategy.pattern;

import net.pazz.design.strategy.Strategy;

/**
 * @author: Peng Jian
 * @date: 2018/5/30 9:40
 * @description: SecondStrategy 第二策略 (*)
 */
public class SecondStrategy implements Strategy {
    @Override
    public void execute(int sum1, int sum2) {
        System.out.println("Called SecondStrategy.execute() sum1 * sum2 = " + (sum1 * sum2));
    }
}
