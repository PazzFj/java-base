package com.pazz.java.linked;

/**
 * @author: 彭坚
 * @create: 2019/12/24 23:34
 * @description: 自定义双向队列
 */
public interface CustomDeque<E> {

    E get(int index);

    boolean add(E element);

    void add(int index, E element);

    void linkLast(E element);

    void linkFirst(E element);

}
