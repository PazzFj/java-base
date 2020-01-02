package com.pazz.java.design.observer;

/**
 * Hex 十六进制
 */
public class ObserverImplB extends Observer {

    public ObserverImplB(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public void update(){
        System.out.println( "Hex String: " + Integer.toHexString(subject.getState()));
    }

}
