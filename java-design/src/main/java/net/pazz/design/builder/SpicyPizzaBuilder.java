package net.pazz.design.builder;

/**
 * @author: Peng Jian
 * @date: 2018/5/31 17:42
 * @description:
 */
public class SpicyPizzaBuilder extends PizzaBuilder {

    public void buildDough()   { pizza.setDough("pan baked"); }
    public void buildSauce()   { pizza.setSauce("hot"); }
    public void buildTopping() { pizza.setTopping("pepperoni+salami"); }

}
