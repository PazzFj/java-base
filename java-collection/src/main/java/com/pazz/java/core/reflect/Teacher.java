package com.pazz.java.core.reflect;

import lombok.Data;

/**
 * @author: 彭坚
 * @create: 2018/12/19 14:21
 * @description:
 */
@Data
public class Teacher {

    private String tCls;
    static{
        System.out.println("static teacher");
    }

    public Teacher() {
        System.out.println("Teacher class ");
    }

    public Teacher(String tCls) {
        System.out.println("Teacher class " + tCls);
        this.tCls = tCls;
    }

}
