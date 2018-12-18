package com.pazz.java.core.juc.example;

/**
 * @author: 彭坚
 * @create: 2018/12/18 9:57
 * @description:
 */
public class Testmain {

    public static void main(String[] args) {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: "+ result);
    }

}
