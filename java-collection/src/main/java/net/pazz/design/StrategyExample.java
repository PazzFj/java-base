package net.pazz.design;

import net.pazz.design.strategy.Context;
import net.pazz.design.strategy.Strategy;
import net.pazz.design.strategy.pattern.FirstStrategy;
import net.pazz.design.strategy.pattern.SecondStrategy;
import net.pazz.design.strategy.pattern.ThirdStrategy;

/**
 * @author: Peng Jian
 * @date: 2018/5/30 9:37
 * @description: 策略模式
 */
public class StrategyExample {

    public static void main(String[] args) {
        Strategy first = new FirstStrategy(); //第一策略 (+)
        Strategy third = new ThirdStrategy(); //第三策略 (/)
        Strategy second = new SecondStrategy(); //第二策略 (*)
        Context context = new Context(first);
        context.execute(5, 5);
    }

}
