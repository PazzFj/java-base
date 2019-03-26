package net.pazz.pattern.abstractFactory;

/**
 * @author: 彭坚
 * @create: 2018/9/17 15:39
 * @description:
 */
public class XBKAbstract extends AbstractFactory {
    @Override
    Object createFactory(String obj) {
        System.out.println("Create XBK Coffee");
        return new Coffee();
    }
}
