package net.pazz.base.datatype;

/**
 * @author: Peng Jian
 * @date: 2018/6/5 13:43
 * @description: Integer
 */
public class IntegerType {

    public static void main(String[] args) {
        Integer integer1 = new Integer(12);
        Integer integer2 = new Integer(12);
        Integer integer3 = Integer.valueOf(12);
        Integer integer4 = Integer.valueOf(12);
        System.out.println(integer1 == integer2);
        System.out.println(integer1.equals(integer2));
        System.out.println(integer3 == integer4);
        System.out.println(integer3.equals(integer4));

        int i1 = integer1;
        System.out.println(i1);

        Class cls1 = integer3.getClass();
        Class[] cs = cls1.getDeclaredClasses();
        Class cls2 = cs[0];
        System.out.println(cls2);



//        int i = Integer.parseInt("11"); //NumberFormatException
//        //缓存池概念  -128 ~ 127
//        Integer i1 = 127;//java在编译的时候,被翻译成-> Integer i3 = Integer.valueOf(128);
//        Integer i2 = new Integer(127);
//        Integer i3 = new Integer(127);  //  new 不相等
//        int i4 = Integer.parseInt("127");
//        System.out.println(i1 == i4);
//        String binary = Integer.toBinaryString(10);
//        System.out.println(binary);
//        int a = 33;
//        int b = 55;
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString(b));
//        // a = 10 0001     b = 11 0111
//        System.out.println(a & b);      //如果相对应位都是1，则结果为1，否则为0
//        System.out.println(a | b);      //如果相对应位都是0，则结果为0，否则为1
//        System.out.println(a ^ b);      //如果相对应位值相同，则结果为0，否则为1
//        int c = 32;
//        //100000
//        System.out.println(c >>> 3);   // 32除8
//        System.out.println(c >> 1);    // 32除2
//        System.out.println(c << 2);    // 32乘4
    }
}
