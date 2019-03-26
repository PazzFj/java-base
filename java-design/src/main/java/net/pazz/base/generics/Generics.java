package net.pazz.base.generics;

import lombok.Data;

import java.util.Collection;

/**
 * @author: Peng Jian
 * @date: 2018/6/4 11:34
 * @description: 泛型类
 */
@Data
public class Generics<T> {

    T value;

    Object object;

    /**
     * 泛型方法 <E>
     */
    public static <E> E testMethod1(E e) {
        System.out.println("E: " + e);
        return e;
    }

    //泛型方法
    public <T> void add(T t) {
        object = t;
    }

    public void testMethod2(Collection<?> collection) {
//        collection.add("a"); //error
//        collection.add(123); //error
    }

    public void testMethod3(Collection<? extends Parent> collection) {
//        collection.add(new Sub()); //报错
//        collection.add(new Parent()); // 报错
        collection.forEach(object -> {
            System.out.println(object);
        });
    }

    /**
     * ? supper T
     * @param collection
     * @return
     */
    public Object testMethod4(Generics<? super T> collection) {
//        collection.add(new Sub());
//        collection.add(new Parent()); // 报错
//        collection.forEach( object -> {
//            System.out.println(object);
//        });

        Parent exampleName = new Parent("name");
        collection.setObject(exampleName);
        System.out.println(collection.getObject());
        return collection.getObject();
    }

}
