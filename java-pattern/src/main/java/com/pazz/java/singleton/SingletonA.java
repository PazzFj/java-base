package com.pazz.java.singleton;

/**
 * @author: Peng Jian
 * @create: 2018/10/9 10:23
 * @description: 第一种单列模式 懒汉式
 */
public class SingletonA {

    private static SingletonA singletonA = null;

    //加同步锁时, 前后两次判断实例是否存在
    public static SingletonA getInstance(){
        if(singletonA == null){
            synchronized (SingletonA.class){
                if(singletonA ==null){
                    singletonA = new SingletonA();
                }
            }
        }
        return singletonA;
    }

    private SingletonA(){}

}
