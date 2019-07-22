package com.pazz.java.design.factory2;

/**
 * @author: 彭坚
 * @create: 2019/3/5 9:47
 * @description:
 */
public interface Person {

    String getSex();

    int getAge();

    String getName();

    void setName(String name);

    void setAge(int age);

    void setSex(String sex);

    void eat();

}
