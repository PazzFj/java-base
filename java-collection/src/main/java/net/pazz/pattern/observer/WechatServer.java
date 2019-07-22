package net.pazz.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭坚
 * @create 2018/9/13 21:38
 * @description: 被观察者
 */
public class WechatServer implements Observable {

    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<Observer> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (list.isEmpty())
            return;
        list.remove(o);
    }

    @Override
    public void notifyObserver() {
        list.forEach(observer -> observer.update(message));
    }

    public void setMessage(String message){
        this.message = message;
        //消息更新，通知所有观察者
        System.out.println("微信服务更新消息： " + message);
        notifyObserver();
    }
}
