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

        // *********************数组传递***********************
        String[] oldStr = new String[10];
        oldStr[0] = "a0";
        oldStr[2] = "a2";
        oldStr[4] = "a4";
        oldStr[6] = "a6";
        String[] newStr = oldStr;  //赋予之后改变旧的值，新的也发生改变了
//        oldStr = null;
        oldStr[0] = "b0";
        newStr[8] = "b8";           ////赋予之后改变新的值，旧的也发生改变了
        newStr[4] = "b3";
        for (int i = 0; i < newStr.length; i++) {
//            System.out.print(newStr[i] + " , ");
            System.out.print(oldStr[i] + " - ");

        }
        System.out.println();
        for (int i = 0; i < newStr.length; i++) {
//            System.out.print(newStr[i] + " , ");
            System.out.print(newStr[i] + " - ");

        }
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
