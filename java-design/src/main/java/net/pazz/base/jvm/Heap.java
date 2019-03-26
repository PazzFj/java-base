package net.pazz.base.jvm;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author: Peng Jian
 * @date: 2018/6/4 14:46
 * @description: 堆
 */
public class Heap {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Heap() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object obj){
        ensureCapacity();
        elements[size++] = obj;
    }

    public Object pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        Object o = elements[--size];
        elements[size] = null;
        return o;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void ensureCapacity(){
        if(size == elements.length){
            elements = Arrays.copyOf(elements, 2 * size+1);
        }
    }
}
