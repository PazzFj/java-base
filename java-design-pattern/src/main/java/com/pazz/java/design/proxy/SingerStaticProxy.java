package com.pazz.java.design.proxy;

/**
 * @author: Peng Jian
 * @create: 2018/10/9 8:34
 * @description: 实现静态代理
 */
public class SingerStaticProxy implements Singer {

    private Singer singer;

    public SingerStaticProxy(Singer singer) {
        this.singer = singer;
    }

    @Override
    public void sing() {
        System.out.println("Static 向观众问好");
        singer.sing();
        System.out.println("Static 谢谢大家");
    }
}
