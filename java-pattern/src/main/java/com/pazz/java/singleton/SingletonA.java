package com.pazz.java.singleton;

/**
 * @author: Peng Jian
 * @create: 2018/10/9 10:23
 * @description:
 */
public class SingletonA {

    private static SingletonA singletonA;

    public static SingletonA getInstance(){
        if(singletonA == null){
            singletonA = new SingletonA();
        }
        return singletonA;
    }

    private SingletonA(){}

}
