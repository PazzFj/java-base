package com.pazz.java.design.factory2;

/**
 * @author: 彭坚
 * @create: 2019/3/5 9:50
 * @description:
 */
public class AbstractProperty implements Person {

    String name;

    int age;

    String sex;

    @Override
    public String getSex() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setAge(int age) {

    }

    @Override
    public void setSex(String sex) {

    }

    @Override
    public void eat() {
        System.out.println("默认吃饭");
    }
}
