package com.pazz.java.design.observer;

/**
 * Binary 二进制
 */
public class ObserverImplA extends Observer {

    public ObserverImplA(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: "+ Integer.toBinaryString(subject.getState()));
    }

}
