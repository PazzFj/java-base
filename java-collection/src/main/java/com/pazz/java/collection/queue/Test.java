package com.pazz.java.collection.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author: 彭坚
 * @create: 2019/1/3 9:19
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        Queue<Example> examples = new ConcurrentLinkedQueue<Example>();
        examples.add(new Example("k1"));
        examples.add(new Example("k2"));
        examples.add(new Example("k3"));
        System.out.println(examples.element()); //检索此队列的头，但不删除。这个方法不同于peek()，只是在这个队列为空时，它会抛出一个异常。
        System.out.println(examples.poll()); //检索并删除该队列的头部
        System.out.println(examples.peek()); //检索但不删除该队列的头部
        System.out.println(examples);
    }

    private static class Example{
        private String name;

        public Example(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Example{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
