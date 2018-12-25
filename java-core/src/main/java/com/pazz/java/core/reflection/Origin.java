package com.pazz.java.core.reflection;

/**
 * @author: 彭坚
 * @create: 2018/12/19 14:21
 * @description:
 */
public class Origin {

    private String name;

    public Origin() {
    }

    public Origin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String orignAddress(){
        return "origin";
    }
}
