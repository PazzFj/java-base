package net.pazz.design;

import net.pazz.design.singleton.*;

/**
 * 单例模式
 */
public class SingletonExample {

    public static void main(String[] args) {
        // enum
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.whateverMethod();

        // 双重锁
        DualSynSingleton dualSynSingleton = DualSynSingleton.getSingleton();
        dualSynSingleton.toString();

        // 懒加载锁
        LazySynSingleton lazySynSingleton = LazySynSingleton.getInstance();
        lazySynSingleton.hashCode();

        // 饿汉式
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        hungrySingleton.getClass();

        //内部类
        InnerClassSingleton innerClassSingleton = InnerClassSingleton.getInstance();
        innerClassSingleton.hashCode();
    }

}
