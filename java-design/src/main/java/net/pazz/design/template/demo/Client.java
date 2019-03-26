package net.pazz.design.template.demo;

/**
 * @author: Peng Jian
 * @date: 2018/8/13 14:53
 * @description:
 */
public class Client {

    public static void main(String[] args) {
        Account account = new CDAccount();
        double v = account.calculateInterest();
        System.out.println(v);
        account = new MoneyMarketAccount();
        double v2 = account.calculateInterest();
        System.out.println(v2);
    }

}
