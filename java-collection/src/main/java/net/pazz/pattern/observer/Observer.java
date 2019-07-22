package net.pazz.pattern.observer;

/**
 * @author 彭坚
 * @create 2018/9/13 21:35
 * @description: 抽象观察者
 * 定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
 */
public interface Observer {

    void update(String message);

}
