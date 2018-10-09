package com.pazz.java.proxy;

import com.pazz.java.proxy.ISinger;

/**
 * @author: Peng Jian
 * @create: 2018/10/9 8:34
 * @description: 代理对象
 */
public class Singer implements ISinger {
    @Override
    public void sing() {
        System.out.println("唱一首歌.");
    }
}
