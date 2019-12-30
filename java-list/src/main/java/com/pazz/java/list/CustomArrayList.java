package com.pazz.java.list;


import java.util.Arrays;
import java.util.Collection;

/**
 * 自定义list 接口实现类
 * @author 彭坚
 * @create 2018/9/12 22:34
 */
public class CustomArrayList<E> extends CustomAbstractList<E> implements CustomList<E> {

    private final static int DEFAULT_CAPACITY = 10;

    private final static Object[] EMPTY_ELEMENTDATA = {};

    private final static Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    private int size;

    private int modCount;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public CustomArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public CustomArrayList(int initialCapacity) {
        //如果初始容量大于0 或者 等于0 否则抛异常
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public CustomArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
        //把集合转成数组存入elementData 并判断elementData是否为空&不为Object[].class就Array.copyOf()
        if ((size = elementData.length) != 0) {
            if (elementData.getClass() != Object[].class) {
                elementData = Arrays.copyOf(elementData, size, Object[].class);
            }
        } else {
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    //如果当前数组为空, 与默认长度10比较,取Math.max(默认长度, 当前集合长度)
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    //添加
    public boolean add(E e) {
        //确保内部数组有足够的空间
        ensureCapacityInternal(size + 1);
        //将元素加入到数组的末尾，完成添加//并且长度++
        elementData[size++] = e;
        return true;
    }

    //在指定的位置插入元素
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    //快速删除
    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
    }

    //根据下标查找
    public E get(int index) {
        //先验证index是否在范围内
        rangeCheck(index);

        return elementData(index);
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        modCount++;
        E oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);

        elementData[--size] = null;
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    //检查下标
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    //确保内部容量
    public void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    //确保容量明确
    public void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        //当前容量长度少于需求长度时（扩容）
        if ((minCapacity - elementData.length) > 0)
            grow(minCapacity);
    }

    //扩容(n = n + n/2)
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    //无限容量
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    @Override
    public int size() {
        return size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public String toString() {
        if (elementData.length == 0)
            return "null";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < elementData.length; i++) {
            sb.append(elementData[i] + ", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
