package net.pazz.design.observer.system;

import net.pazz.design.observer.Observer;
import net.pazz.design.observer.Subject;

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
