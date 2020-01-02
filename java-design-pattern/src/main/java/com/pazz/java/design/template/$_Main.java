package com.pazz.java.design.template;

/**
 * @author: 彭坚
 * @create: 2020/1/2 23:01
 * @description: 模板模式:
 */
public class $_Main {

    public static void main(String[] args) {
        AbstractTemplate template = new TemplateHaiImpl();
        AbstractTemplate templateB = new TemplateHelloImpl();
        template.temp();
        templateB.temp();
    }

}
