package net.pazz.design.strategy.pattern;

import net.pazz.design.strategy.Strategy;

/**
 * @author: Peng Jian
 * @date: 2018/5/30 9:41
 * @description: ThirdStrategy  第三策略 (/)
 */
public class ThirdStrategy implements Strategy {
    @Override
    public void execute(int sum1, int sum2) {
        System.out.println("Called ThirdStrategy.execute() sum1 / sum2 = " + (sum1 / sum2));
    }
}
