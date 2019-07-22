package com.pazz.java.design.factory2;

/**
 * @author: 彭坚
 * @create: 2019/3/5 9:49
 * @description:
 */
public class ManDuck extends AbstractProperty implements Person {

    @Override
    public String getSex() {
        return super.sex;
    }

    @Override
    public int getAge() {
        return super.age;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }

    @Override
    public void setAge(int age) {
        super.age = age;
    }

    @Override
    public void setSex(String sex) {
        super.sex = sex;
    }

    @Override
    public void eat() {
        System.out.println("男的吃鸭");
    }
}
