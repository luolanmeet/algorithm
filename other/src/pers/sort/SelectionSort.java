package pers.sort;

import java.util.Arrays;

/**
 * 选择排序（Selection Sort）是一种简单直观的排序算法。
 * 它的工作原理是：第一次从待排序的数据元素中选出最小（大）的一个元素，存放在序列的起始（末尾），
 * 然后再从剩余的未排序元素中寻找到最小（大）元素，
 * 然后放到已排序的序列的末尾（起始）。以此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法。
 */
public class SelectionSort {
    
    public static void sort(int[] array) {
    
        int putIndex = array.length - 1;
        
        for (int len = array.length; len > 0; len--) {
        
            int tmpIndex = 0;
            int tmpMax = array[0];
            // 从此次循环中找到最大的值
            for (int i = 1; i < len; i++) {
                if (tmpMax < array[i]) {
                    tmpIndex = i;
                    tmpMax = array[i];
                }
            }
    
            array[tmpIndex] = array[putIndex];
            array[putIndex--] = tmpMax;
        }
        
    }
    
    public static void main(String[] args) {
        int[] array1 = {5,1,1,2,0,0,0};
        sort(array1);
        System.out.println(Arrays.toString(array1));
        
        int[] array2 = {10,10,-4,7,5,5,1,1,-1,2,110,20};
        sort(array2);
        System.out.println(Arrays.toString(array2));
    
        int[] array3 = {5,2};
        sort(array3);
        System.out.println(Arrays.toString(array3));
    }
    
}
