package net.pazz.pattern.abstractFactory;

/**
 * @author: 彭坚
 * @create: 2018/9/17 15:42
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        ProvideFactory provideFactory = new ProvideFactory();
        AbstractFactory<XBK> abstractFactory = provideFactory.create("XBK");
        XBK xbk = abstractFactory.createFactory("");
        xbk.drink();
    }

}
