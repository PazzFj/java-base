package net.pazz.design.observer.system;

import net.pazz.design.observer.Observer;
import net.pazz.design.observer.Subject;

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
