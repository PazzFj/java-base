package com.pazz.java.core.reflect;

import lombok.Data;

/**
 * @author: 彭坚
 * @create: 2018/12/19 14:23
 * @description:
 */
@Data
public class Student extends Teacher implements Action {

    private String sName;
    static{
        System.out.println("static student");
    }

    public Student() {
        System.out.println("Student name ");
    }

    public Student(String sName, String tCls) {
        super(tCls);
        this.sName = sName;
        System.out.println("Student name " + sName);
    }

    @Override
    public void study() {
        System.out.println("学习...");
    }

    @Override
    public String toString() {
        return "Student{" +
                "sName='" + sName + '\'' +
                '}';
    }
}
