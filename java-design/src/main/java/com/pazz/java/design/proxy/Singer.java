package com.pazz.java.design.proxy;

/**
 * @author: Peng Jian
 * @create: 2018/10/9 8:34
 * @description: 代理对象实现接口
 */
public class Singer implements ISinger {
    @Override
    public void sing() {
        System.out.println("我们会的歌.");
    }
}
