package net.pazz.pattern.observer;

/**
 * @author 彭坚
 * @create 2018/9/13 21:50
 * @description: 测试方法
 */
public class Main {

    public static void main(String[] args) {
        User zhangSan = new User("ZhangSan");
        User liSi = new User("LiSi");
        User wangWu = new User("WangWu");

        Observable observable = new WechatServer();
        observable.registerObserver(zhangSan);
        observable.registerObserver(liSi);
        observable.registerObserver(wangWu);
        ((WechatServer) observable).setMessage("JAVA是世界上最好用的语言！");

        observable.removeObserver(liSi);
        ((WechatServer) observable).setMessage("JAVA还是世界上最好用的语言！");
    }

}
