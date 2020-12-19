package com.pazz.java.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: 彭坚
 * @create: 2020/3/26 0:36
 * @description:
 */
public class $_Main {

    public static void main(String[] args) throws Exception {
        ArrayBlockingQueue<Node> objects = new ArrayBlockingQueue<>(1000);

        for (int i = 0; i < 100; i++) {
            objects.put(new Node("" + i));
        }

        System.out.println(objects.peek().str);
    }


    public static class Node {
        String str;

        public Node(String str) {
            this.str = str;
        }
    }

}
