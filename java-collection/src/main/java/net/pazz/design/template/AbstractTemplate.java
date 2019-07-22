package net.pazz.design.template;

/**
 * @author: Peng Jian
 * @date: 2018/8/13 14:30
 * @description:
 */
public abstract class AbstractTemplate {

    /**
     * 模板方法
     */
    public void templateMethod(){
        //调用基本方法
        hookMethod();
        abstractMethod();
        concreteMethod();
    }

    /**
     * 基本方法(空方法)
     */
    public void hookMethod(){
        System.out.println("AbstractTemplate#hookMethod()");
    }

    /**
     * 基本方法的声明（由子类实现）
     */
    public abstract void abstractMethod();

    /**
     * 基本方法（已经实现）
     */
    public void concreteMethod(){
        System.out.println("AbstractTemplate#concreteMethod()");
    }

}
