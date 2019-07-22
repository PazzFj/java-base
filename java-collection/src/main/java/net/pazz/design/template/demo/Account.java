package net.pazz.design.template.demo;

import lombok.Data;

/**
 * @author: Peng Jian
 * @date: 2018/8/13 14:46
 * @description:
 */
@Data
public abstract class Account {

    private double rate; //比率

    /**
     * 模板方法，计算利息数额
     * @return    返回利息数额
     */
    protected final double calculateInterest(){
        String accountType = doCalculateAccountType();
        double interestRate = doCalculateInterestRate();
        double calculateAmount = calculateAmount(accountType);
        return calculateAmount * interestRate;
    }

    /**
     * 基本方法留给子类实现
     */
    protected abstract String doCalculateAccountType();

    /**
     * 基本方法留给子类实现
     */
    protected abstract double doCalculateInterestRate();

    private double calculateAmount(String accountType){
        /**
         * 省略相关的业务逻辑
         */
        return rate;
    }

}
