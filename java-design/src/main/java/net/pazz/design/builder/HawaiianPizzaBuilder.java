package net.pazz.design.builder;

/**
 * @author: Peng Jian
 * @date: 2018/5/31 17:41
 * @description:
 */
public class HawaiianPizzaBuilder extends PizzaBuilder {

    public void buildDough()   { pizza.setDough("cross"); }
    public void buildSauce()   { pizza.setSauce("mild"); }
    public void buildTopping() { pizza.setTopping("ham+pineapple"); }

}
