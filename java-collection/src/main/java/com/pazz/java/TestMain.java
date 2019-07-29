package com.pazz.java;

/**
 * @author: 彭坚
 * @create: 2019/1/25 11:17
 * @description:
 */
public class TestMain {

    public static void main(String[] args) {
        TestValue test = new TestValue();
        System.out.println("如果在这里设置断点，则输出1");
        System.out.println(test.getValue());
        System.out.println("如果不设置断点，则输出0");
    }

    static class TestValue {
        private volatile int value = 0;

        public int getValue() {
            return value;
        }

        public int setValue() {
            if (value == 0) {
                synchronized (this) {
                    if (value == 0) {
                        value = 1;
                    }
                }
            }
            return value;
        }

        @Override
        public String toString() {
            return "This value is:" + setValue();
        }
    }

}
