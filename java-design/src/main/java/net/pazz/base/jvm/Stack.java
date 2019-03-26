package net.pazz.base.jvm;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author: Peng Jian
 * @date: 2018/6/4 14:46
 * @description: 栈
 */
public class Stack<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
//        elements = new E[DEFAULT_INITIAL_CAPACITY];   //错误
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
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
