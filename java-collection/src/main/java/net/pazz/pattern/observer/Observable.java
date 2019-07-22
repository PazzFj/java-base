package net.pazz.pattern.observer;

/**
 * @author 彭坚
 * @create 2018/9/13 21:33
 * @description: 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 */
public interface Observable {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();

}
