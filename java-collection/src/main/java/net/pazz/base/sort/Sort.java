package net.pazz.base.sort;

import java.util.Arrays;

public class Sort {

    // 冒泡排序
    public static void mp(int[] n){
        int a;
        for (int i = 0; i < n.length; i++) {
            for (int j = i; j < n.length; j++) {
                if(n[i] > n[j]){
                    a = n[i];
                    n[i] = n[j];
                    n[j] = a;
                }
            }
        }
        System.out.println(Arrays.toString(n));
    }

    //二分排序
    public static int ef(int[] n, int tag){
        int start = 0;
        int end = n.length - 1;
        //确保不会出现重复查找，越界
        while(start <= end){
            //计算出中间索引值
            int middle = (start + end) / 2 ;//防止溢出
            if(n[middle] == tag){
                return middle;
            }
            if(n[middle] > tag){
                end = middle - 1;
            }
            if(n[middle] < tag){
                start = middle + 1;
            }
        }
        return -1;
    }

    //二分排序
    public static int binarySearch(int[] srcArray, int des) {
        //定义初始最小、最大索引
        int low = 0;
        int high = srcArray.length - 1;
        //确保不会出现重复查找，越界
        while (low <= high) {
            //计算出中间索引值
            int middle = (high + low)>>>1;//防止溢出
            if (des == srcArray[middle]) {
                return middle;
                //判断下限
            } else if (des < srcArray[middle]) {
                high = middle - 1;
                //判断上限
            } else {
                low = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }

}
