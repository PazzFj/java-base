package com.pazz.java.collection.list;

/**
 * @author: Peng Jian
 * @create: 2018/10/29 17:09
 * @description: 手写 LinkedList
 */
public class LinkedListExample<E> {

    transient NodeExample<E> first;
    transient NodeExample<E> last;
    transient int size = 0;

    public boolean add(E element) {
        linkLast(element);
        return true;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    /**
     * 遍历得到下标所对应的值
     */
    NodeExample<E> node(int index) {
        if (index < size >> 1) {
            NodeExample<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            NodeExample<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IllegalStateException("index out~");
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }


    /**
     * 添加到头部
     */
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

    public void add(int index, E element) {
        checkElementIndex(index); //+1
        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    /*
        succ 下标对应的链点
     */
    private void linkBefore(E element, NodeExample<E> succ) {
        final NodeExample<E> pred = succ.prev; //
        final NodeExample<E> newNode = new NodeExample<>(pred, element, succ);
        succ.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    private void linkFirst(E element) {
        final NodeExample<E> f = first;
        final NodeExample<E> newNode = new NodeExample<>(null, element, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
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
