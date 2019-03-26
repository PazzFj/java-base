package net.pazz.design.strategy;

/**
 * @author: Peng Jian
 * @date: 2018/5/30 9:42
 * @description: Context 策略封装
 */
public class Context {

    Strategy strategy;

    public Context (Strategy strategy){
        this.strategy = strategy;
    }

    public void execute(int sum1, int sum2) {
        this.strategy.execute(sum1, sum2);
    }

}
