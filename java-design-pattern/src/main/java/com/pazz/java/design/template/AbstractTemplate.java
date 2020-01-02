package com.pazz.java.design.template;

/**
 * @author: Peng Jian
 * @create: 2018/10/9 9:50
 * @description: 模板模式：
 */
public abstract class AbstractTemplate {

    abstract void hello();

    public void smile() {
        System.out.println("微笑!");
    }

    public void handshake() {
        System.out.println("握手");
    }

    public void temp() {
        smile();
        handshake();
        hello();
    }

}
