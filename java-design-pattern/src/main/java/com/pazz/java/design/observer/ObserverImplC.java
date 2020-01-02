package com.pazz.java.design.observer;

/**
 * Octal 八进制
 */
public class ObserverImplC extends Observer {

    public ObserverImplC(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
