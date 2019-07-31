package com.pazz.java.collection.list.list;

import java.util.Collection;
import java.util.List;

/**
 * @author 彭坚
 * @create 2018/9/12 22:34
 * @see List
 */
public interface MList<E> extends List<E> {

    int size();						            //集合长度
    boolean isEmpty();					        //集合是否为空
    boolean contains(Object o);				    //集合是否包含该对象
    Object[] toArray();					        //将集合转为数组
    <T> T[] toArray(T[] a);					    //将集合转为给定的数据
    boolean add(E e);					        //添加元素
    boolean remove(Object o);				    //从集合中清除给定的元素
    boolean containsAll(Collection<?> c);			//是否包含该集合
    boolean addAll(Collection<? extends E> c);		//添加指定的集合
    boolean addAll(int index, Collection<? extends E> c);	//给定的下标添加指定的集合
    boolean removeAll(Collection<?> c);			//清除该集合中包含的
    boolean retainAll(Collection<?> c);			//移除指定的集合所不存在的元素
    void clear();						        //清除元素集合
    E get(int index);					        //下标所对应的元素
    E set(int index, E element);				//替换指定的元素根据下标
    void add(int index, E element);				//根据下标插入元素
    E remove(int index);					    //清下标所对应的元素
    int indexOf(Object o);					    //对象在集合中的第一个下标
    int lastIndexOf(Object o);				    //查找最后一个对象
    MList<E> subList(int fromIndex, int toIndex);	//截取集合


}
