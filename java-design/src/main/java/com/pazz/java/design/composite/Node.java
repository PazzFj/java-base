package com.pazz.java.design.composite;

/**
 * @author: 彭坚
 * @create: 2018/12/27 10:14
 * @description: 将文件与目录统一看作是一类节点，做一个抽象类来定义这种节点，然后以其实现类来区分文件与目录，在实现类中分别定义各自的具体实现内容
 */
public abstract class Node {

    private String name;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNode(Node directory) throws Exception {
        throw new Exception("Invalid exception");
    }

    // 显示
    public abstract void display();

}
