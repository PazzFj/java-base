package com.pazz.java.template;

/**
 * @author: Peng Jian
 * @create: 2018/10/9 9:50
 * @description:
 */
public abstract class AbstractTemplate {

    abstract void eat();

    public void hello(){
        System.out.println("hello!");
    }

    public void name(){
        System.out.println("name");
    }

    public void temp(){
        hello();
        eat();
        name();
    }

}
