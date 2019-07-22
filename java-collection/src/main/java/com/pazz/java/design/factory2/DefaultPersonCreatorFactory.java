package com.pazz.java.design.factory2;

/**
 * @author: 彭坚
 * @create: 2019/3/5 9:59
 * @description:
 */
public class DefaultPersonCreatorFactory implements PersonCreatorFactory {

    @Override
    public Person create(String sex) {
        if ("男".equals(sex)) {
            return new ManDuck();
        }
        return new WomanChook();
    }

}
