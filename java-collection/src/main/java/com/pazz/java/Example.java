package com.pazz.java;

/**
 * @author: Peng Jian
 * @create: 2018/11/3 14:45
 * @description:
 */
public class Example {
    private String attr;

    public Example() {
    }

    public Example(String attr) {
        this.attr = attr;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        return "Example{" +
                "attr='" + attr + '\'' +
                '}';
    }
}
