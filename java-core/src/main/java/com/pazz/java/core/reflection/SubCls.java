package com.pazz.java.core.reflection;

/**
 * @author: 彭坚
 * @create: 2018/12/19 14:23
 * @description:
 */
public class SubCls extends Origin implements Action {

    private String subStr;

    @Override
    public void eat() {
        System.out.println("吃东西..");
    }

    public String getSubStr() {
        return subStr;
    }

    public void setSubStr(String subStr) {
        this.subStr = subStr;
    }

    private SubCls returnSub(){
        return new SubCls();
    }
}
