package com.pazz.java.design.observer.impl;

import com.pazz.java.design.observer.Observer;
import com.pazz.java.design.observer.Subject;

/**
 * Binary 二进制
 */
public class BinaryObserver extends Observer {

    public BinaryObserver (Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: "+ Integer.toBinaryString(subject.getState()));
    }

}
