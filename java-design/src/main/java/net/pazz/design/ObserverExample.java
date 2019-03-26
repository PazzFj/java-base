package net.pazz.design;

import net.pazz.design.observer.Subject;
import net.pazz.design.observer.system.BinaryObserver;
import net.pazz.design.observer.system.HexObserver;
import net.pazz.design.observer.system.OctalObserver;

/**
 * Observer 观察者模式
 */
public class ObserverExample {

    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new HexObserver(subject);
        new OctalObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);

    }

}
