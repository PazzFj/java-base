package com.pazz.java.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/27 9:40
 * @description: 目录节点
 */
public class Directory extends Node {

    //目录的下级目录列表
    List<Node> directoryList = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    //新增下级目录
    public void addNode(Node Directory) throws Exception {
        directoryList.add(Directory);
    }

    //显示下级目录及文件
    @Override
    public void display() {
        System.out.println(getName());
        for (Node directory : directoryList) {
            directory.display();//递归显示目录列表
        }
    }

}
