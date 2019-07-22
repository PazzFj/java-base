package net.pazz.design;

import net.pazz.design.builder.*;

/**
 * @author: Peng Jian
 * @date: 2018/5/31 17:28
 * @description:
 */
public class BuilderExample {

    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiian_pizzaBuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicy_pizzaBuilder = new SpicyPizzaBuilder();

        waiter.setPizzaBuilder(hawaiian_pizzaBuilder);
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();
        System.out.println(pizza);
    }

}
