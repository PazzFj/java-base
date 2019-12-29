package com.pazz.java.search;

/**
 * @author: 彭坚
 * @create: 2019/12/29 16:31
 * @description: 查找
 * <p>
 * 空间复杂度
 *   算法的空间复杂度并不是计算实际占用的空间，而是计算整个算法的辅助空间单元的个数
 * <p>
 * 非递归方式：
 *   由于辅助空间是常数级别的所以：
 *   空间复杂度是O(1);
 * <p>
 * 递归方式：
 *  递归的次数和深度都是log2 N,每次所需要的辅助空间都是常数级别的：
 *  空间复杂度：O(log2N )
 */
public class Search {

    /**
     * 二分查找法：
     * <p>
     * 优点是比较次数少，查找速度快，平均性能好；
     * <p>
     * 其缺点是要求待查表为有序表，且插入删除困难。
     * <p>
     * 因此，折半查找方法适用于不经常变动而查找频繁的有序列表。
     * <p>
     * 使用条件：查找序列是顺序结构，有序。
     */
    public static int binarySearch(int[] srcArray, int tag) {
        int start = 0;
        int end = srcArray.length - 1;

        if (tag < srcArray[start] || tag > srcArray[end] || start > end) {
            return -1;
        }

        //确保不会出现重复查找，越界
        while (start <= end) {
            //计算出中间索引值
            int middle = (start + end) / 2;//防止溢出
            if (srcArray[middle] == tag) {
                return middle;
            }
            //判断下限
            if (srcArray[middle] > tag) {
                end = middle - 1;
            }
            //判断上限
            if (srcArray[middle] < tag) {
                start = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }

}
