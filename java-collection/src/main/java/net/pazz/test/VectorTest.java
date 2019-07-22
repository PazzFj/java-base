package net.pazz.test;

import java.util.List;
import java.util.Vector;

/**
 * @author: 彭坚
 * @create: 2018/9/17 14:13
 * @description:
 */
public class VectorTest {

    public static void main(String[] args) {
        List<String> vector = new Vector<>();
        vector.add("aa");
        vector.add("bb");
        vector.add("cc");
        vector.add("dd");
        vector.add("ee");
        vector.add("ee1");
        vector.add("ee2");
        vector.add("ee3");
        vector.add("ee4");
        vector.add("ee5");
        vector.add("ee6");
        for (int i = 0; i < 40 ; i++) {
            vector.add("es"+i);
        }
        System.out.println(vector);
    }

}
