package pers.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
 *
 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 *  1. 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率。
 *  2. 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位。
 *
 *  希尔排序是不稳定的，存在增量，没有按照顺序比较，是会破坏稳定性的
 */
public class ShellSort {
    
    public static void sort(int[] array) {

        int len = array.length;
        // 增量
        int gap = len;

        while (gap > 0) {

            for (int i = gap; i < len; i++) {

                int tmp = array[i];
                int j = i - gap;

                // 跨增量排序
                while (j >= 0 && array[j] > tmp) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = tmp;
            }

            gap /= 2;
        }
    }

    public static void main(String[] args) {
        int[] array1 = {5,1,1,2,0,0,0,3};
        sort(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {10,10,-4,7,5,5,1,1,-1,2,110,20,120};
        sort(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {15,2};
        sort(array3);
        System.out.println(Arrays.toString(array3));
    }

}
