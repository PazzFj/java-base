package net.pazz.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortMain {

    public static void main(String[] args) {
        int [] t = new int[]{1, 98, 5, 53, 154, 48, 8, 7, 99, 66};

//        // 空集合
//        int [] base = new int[10];
//        // 0
//        System.out.println(base[1]);
//
//        String [] str = new String[10];
//
//        System.out.println(str[1]);

        List<String> list = Arrays.asList("peter", "anna", "mike", "xenia", "aab", "ccc");
        Collections.sort(list); //排序
        System.out.println(list);
    }

}
