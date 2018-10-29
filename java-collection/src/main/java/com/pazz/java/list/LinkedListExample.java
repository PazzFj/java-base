package com.pazz.java.list;

/**
 * @author: Peng Jian
 * @create: 2018/10/29 17:09
 * @description:
 */
public class LinkedListExample<E> {

    transient NodeExample<E> first;
    transient NodeExample<E> last;
    transient int size = 0;

    public boolean add(E element){
        linkLast(element);
        return true;
    }

    void linkLast(E element) {
        final NodeExample l = last;
        final NodeExample newNode = new NodeExample(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    private void linkFirst(E element){
        final NodeExample<E> f = first;
        final NodeExample<E> newNode = new NodeExample<>(null, element, f);
        first = newNode; //添加在头部
        if(f == null){
            last = newNode;
        }else {
            f.prev = newNode;
        }
        size++;
    }


    private static class NodeExample<E> {
        E item;
        NodeExample<E> prev;
        NodeExample<E> next;

        NodeExample(NodeExample<E> prev, E item, NodeExample<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

}
