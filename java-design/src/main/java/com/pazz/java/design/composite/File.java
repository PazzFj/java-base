package com.pazz.java.design.composite;

/**
 * @author: 彭坚
 * @create: 2018/12/27 9:43
 * @description: 文件节点
 */
public class File extends Node {

    public File(String name) {
        super(name);
    }

    //文件显示方法
    @Override
    public void display() {
        System.out.println(getName());
    }

}
