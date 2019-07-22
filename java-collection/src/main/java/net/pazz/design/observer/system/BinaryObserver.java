package net.pazz.design.observer.system;

import net.pazz.design.observer.Observer;
import net.pazz.design.observer.Subject;

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
