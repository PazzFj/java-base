package com.pazz.java.design.template;

/**
 * @author: Peng Jian
 * @create: 2018/10/9 10:08
 * @description:
 */
public class TemplateTest extends AbstractTemplate {
    @Override
    void eat() {
        System.out.println("eat");
    }

    @Override
    public void name() {
        System.out.println("my name");
    }
}
