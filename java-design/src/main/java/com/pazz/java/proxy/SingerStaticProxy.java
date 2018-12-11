package com.pazz.java.proxy;

/**
 * @author: Peng Jian
 * @create: 2018/10/9 8:34
 * @description: 实现代理
 */
public class SingerStaticProxy implements ISinger {

    private ISinger singer;

    public SingerStaticProxy(ISinger singer){
        this.singer = singer;
    }

    @Override
    public void sing() {
        System.out.println("向观众问好");
        singer.sing();
        System.out.println("谢谢大家");
    }
}
