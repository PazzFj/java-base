package com.pazz.java.sort;

import java.util.Arrays;

public class Sort {

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        int a;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    a = arr[i];
                    arr[i] = arr[j];
                    arr[j] = a;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
