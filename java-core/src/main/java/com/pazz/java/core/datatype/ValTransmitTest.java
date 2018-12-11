package com.pazz.java.core.datatype;

/**
 * @author: Peng Jian
 * @create: 2018/10/30 9:36
 * @description: 值传递与对象传递
 */
public class ValTransmitTest {

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
        v1 = new Val("kobe");//生成新得对象
        System.out.println(v1);
        System.out.println(v2);
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

}
