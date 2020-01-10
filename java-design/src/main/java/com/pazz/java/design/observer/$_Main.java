package com.pazz.java.design.observer;

/**
 * @author: Peng Jian
 * @create: 2020/1/2 17:42
 * @description: 观察者模式
 */
public class $_Main {

    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observerA = new ObserverImplA(subject);
        Observer observerB = new ObserverImplB(subject);
        Observer observerC = new ObserverImplC(subject);
        subject.attach(observerA);
        subject.attach(observerB);
        subject.attach(observerC);

        subject.notifyAllObservers();
    }

}
