package net.pazz.design.observer;

/**
 * Observer 观察者
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();

}
