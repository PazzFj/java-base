package com.pazz.java.collection.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: 彭坚
 * @create: 2019/4/28 16:36
 * @description:
 */
public class LinkedQueueTest {

    public static void main(String[] args) throws Exception {
        LinkedBlockingQueue<Object> objects = new LinkedBlockingQueue<>();
        for (int i = 0; i < 1000; i++) {
            objects.put(new Entitys("n" + i));
        }
        System.out.println(objects.peek()); //取头部
        System.out.println(objects.poll()); //取头部
    }

    static class Entitys{
        String name;

        public Entitys(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Entitys{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
