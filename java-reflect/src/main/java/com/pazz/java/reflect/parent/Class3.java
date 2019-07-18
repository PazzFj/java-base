package com.pazz.java.reflect.parent;

import lombok.Data;

/**
 * @author: 彭坚
 * @create: 2019/5/16 17:48
 * @description:
 */
@Data
public class Class3 extends Class2<Integer> implements Inter2 {

    private String name3;

    @Override
    public void t2() {
        System.out.println("@2");
    }

    @Override
    public void t1() {
        System.out.println("@1");
    }
}
