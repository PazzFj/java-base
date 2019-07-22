package net.pazz.design.builder;

/**
 * @author: Peng Jian
 * @date: 2018/5/31 17:33
 * @description:
 */
public abstract class PizzaBuilder {

    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizzaProduct() {
        this.pizza = new Pizza();
    }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();

}
