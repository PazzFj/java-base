package com.pazz.java.core.datatype;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Peng Jian
 * @create: 2018/10/30 9:36
 * @description: 值传递与对象传递
 */
public class ValTransmitTest {

    @Test
    public void test1(){
        String s1 = "aaa";
        String s2 = s1;
        s1.replace("a", "b");
        System.out.println(s1);
        System.out.println(s2);
    }

    public static void main(String[] args) {

        // *******************值传递***********************
        String s1 = "aaa";
        String s2 = s1;
        s1 = "bbb";
        System.out.println(s1);
        System.out.println(s2);

        int i1 = 100;
        int i2 = i1;
        i1 = 200;
        System.out.println(i1);
        System.out.println(i2);

        char c1 = 'y';
        char c2 = c1;
        c1 = 'n';
        System.out.println(c1);
        System.out.println(c2);

        long l1 = 123l;
        long l2 = l1;
        l1 = 456l;
        System.out.println(l1);
        System.out.println(l2);

        // ********************引用传递***********************
        Val v1 = new Val("admin");
        Val v2 = v1;
        v2.setName("sync");// = new Val("kobe");//生成新得对象
        System.out.println(v1);
        System.out.println(v2);

        // *********************数组传递***********************
        List<String> namesA = newNames();
        List<String> namesB = namesA;
        namesB.add("新增DD");
        namesA.add("修改UU");
        System.out.println(namesA);
        System.out.println(namesB);

        //**********************map对象******
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        map.put("test", list);
        list.add("delay");
        System.out.println(map);

        //*************
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("test1", "test1");
        map1.put("test2", "test2");
        Map<String, String> map2 = new HashMap<String, String>();
        map2 = map1;
        map1.put("test3", "test3");
        map2.put("test4", "test4");
        System.out.println(map1);
        System.out.println(map2.size());

        //***********
        TestA a = new TestA();
        TestA b = a;
        a = null;
        System.out.println(a);
        System.out.println(b);
    }

    public static List newNames(){
        List<String> names = new ArrayList<>();
        names.add("A原子性");
        names.add("C一致性");
        names.add("I隔离性");
        names.add("D持久性");
        return names;
    }

    static class Val {
        String name;

        public Val() {
        }

        public Val(String name) {
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
            return "Val{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class TestA{

    }

}
