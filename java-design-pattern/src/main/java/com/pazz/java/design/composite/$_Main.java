package com.pazz.java.design.composite;

/**
 * 组合模式:
 *
 * @Auther peng jian
 * @Date 2020/1/2 15:19
 */
public class $_Main {
    public static void main(String[] args) throws Exception {
        System.out.println("****************组合者模式***************");
        System.out.println("************************");
        Directory directory = new Directory("E:\\download");
        createTree(directory);
        directory.display();
    }

    public static void createTree(Node directory) throws Exception {
        java.io.File file = new java.io.File(directory.getName());
        java.io.File[] f = file.listFiles();

        for (java.io.File fi : f) {
            if (fi.isFile()) {
                Node filer = new File(fi.getAbsolutePath());
                directory.addNode(filer);
            }
            if (fi.isDirectory()) {
                Node node = new Directory(fi.getAbsolutePath());
                directory.addNode(node);
                createTree(node); //使用递归生成树结构
            }
        }
    }
}
