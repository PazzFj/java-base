package com.pazz.java.design.observer.impl;

import com.pazz.java.design.observer.Observer;
import com.pazz.java.design.observer.Subject;

/**
 * Octal 八进制
 */
public class OctalObserver extends Observer {

    public OctalObserver (Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
