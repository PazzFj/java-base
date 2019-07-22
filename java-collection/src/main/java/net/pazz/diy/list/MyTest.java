package net.pazz.diy.list;

import java.util.Iterator;

/**
 * @author: 彭坚
 * @create: 2018/9/11 16:32
 * @description:
 */
public class MyTest {

    public static void main(String[] args) {
        MyList<String> myList = new MyArrayList<>(0);
        myList.add("11");
        myList.add("22");
        myList.add("33");
//        System.out.println(myList);
//        myList.remove(2);
//        System.out.println(myList);
//        myList.remove("22");
//        System.out.println(myList);

//        System.out.println(myList.contains("11"));
        Iterator iterator = myList.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }

    }

}
