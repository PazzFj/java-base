package net.pazz.pattern.abstractFactory;

/**
 * @author: 彭坚
 * @create: 2018/9/17 15:38
 * @description:
 */
public class KFCAbstract extends AbstractFactory {
    @Override
    Object createFactory(String obj) {
        System.out.println("create FKC Drumstick");
        return new Drumstick();
    }
}
