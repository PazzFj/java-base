package com.pazz.java.design.observer;

/**
 * Observer 观察者
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();

}
