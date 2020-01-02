package com.pazz.java.design.observer.impl;

import com.pazz.java.design.observer.Observer;
import com.pazz.java.design.observer.Subject;

/**
 * Hex 十六进制
 */
public class HexObserver extends Observer {

    public HexObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public void update(){
        System.out.println( "Hex String: " + Integer.toHexString(subject.getState()));
    }

}
