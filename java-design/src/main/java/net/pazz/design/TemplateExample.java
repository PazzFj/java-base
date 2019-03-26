package net.pazz.design;

import net.pazz.design.template.AbstractTemplate;
import net.pazz.design.template.ConcreteTemplate;

/**
 * @author: 彭坚
 * @create: 2018/8/22 11:13
 * @description:
 */
public class TemplateExample {

    public static void main(String[] args) {
        AbstractTemplate at = new ConcreteTemplate();
        at.templateMethod();
    }

}
