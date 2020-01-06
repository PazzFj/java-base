package com.pazz.java.juc.example;

/**
 * @author: 彭坚
 * @create: 2018/12/18 9:57
 * @description:
 */
public class $_Main {

    public static void main(String[] args) {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.getInstance().checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: "+ result);
    }

}
