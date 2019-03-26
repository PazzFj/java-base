package net.pazz.base.generics;

/**
 * @author: Peng Jian
 * @date: 2018/6/4 14:15
 * @description:
 */
public class Parent {

    private String name;

    public Parent(String name) {
        System.out.println("name: " + name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
