package net.pazz.pattern.abstractFactory;

/**
 * @author: 彭坚
 * @create: 2018/9/17 15:41
 * @description:
 */
public class ProvideFactory {

    public AbstractFactory create(String s){
        if (s.equals("XBK")){
            return new XBKAbstract();
        }else {
            return new KFCAbstract();
        }
    }

}
