package com.pazz.java.design.singleton;

/**
 * @author 彭坚
 * @create 2018/10/11 22:35
 * @description: 单列模式第三种 静态内部类
 */
public class SingletonC {

    private SingletonC() {
    }

    public static SingletonC initialInstance() {
        return SingletonHolder.singleton;
    }

    private static class SingletonHolder {

        private static final SingletonC singleton = new SingletonC();

    }

}
