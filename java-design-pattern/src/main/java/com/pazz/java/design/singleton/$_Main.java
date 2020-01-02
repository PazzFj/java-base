package com.pazz.java.design.singleton;

/**
 * @author: 彭坚
 * @create: 2020/1/2 22:25
 * @description: 单例模式
 */
public class $_Main {
    public static void main(String[] args) {
        // volatile 内存可见性
        // 懒汉式, 线程不安全(无锁)
        LazySingleton lazySingleton = LazySingleton.getInstance();
        // 懒汉式, 线程安全(双重锁)
        DualSynSingleton dualSynSingleton = DualSynSingleton.getInstance();
        // 饿汉式, 线程安全(无锁)
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        // 懒汉式, 线程安全(方法加锁)
        LazySynSingleton lazySynSingleton = LazySynSingleton.getInstance();

        System.out.println(lazySynSingleton);
        System.out.println(hungrySingleton);
        System.out.println(lazySingleton);
        System.out.println(dualSynSingleton);
    }
}
