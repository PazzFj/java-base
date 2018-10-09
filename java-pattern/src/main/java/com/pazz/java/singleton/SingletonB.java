package com.pazz.java.singleton;

/**
 * @author: Peng Jian
 * @create: 2018/10/9 10:25
 * @description:
 */
public class SingletonB {

    private static SingletonB singletonB = new SingletonB();

    public static SingletonB getInstance(){
        if(singletonB == null){
            throw new NullPointerException("null");
        }
        return singletonB;
    }

    private SingletonB (){}

}
