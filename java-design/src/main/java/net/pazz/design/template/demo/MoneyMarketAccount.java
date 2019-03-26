package net.pazz.design.template.demo;

/**
 * @author: Peng Jian
 * @date: 2018/8/13 14:52
 * @description:
 */
public class MoneyMarketAccount extends Account {
    @Override
    protected String doCalculateAccountType() {
        return "Money Market";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.045;
    }
}
