package net.pazz.design.template.demo;

/**
 * @author: Peng Jian
 * @date: 2018/8/13 14:52
 * @description:
 */
public class CDAccount extends Account {
    @Override
    protected String doCalculateAccountType() {
        return "Certificate of Deposite";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.06;
    }
}
