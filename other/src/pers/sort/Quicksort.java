package pers.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 分别从数组两端进行扫描，并且将扫描到的元素与中轴相比较。
 * 从左到右扫描（i表示），因为希望小于中轴的元素都在中轴的左边，
 * 所以扫描会忽略小于中轴的元素，直到遇到第一个大于中轴的元素才会停止。
 *
 * 从右到左扫描（j表示），因为希望大于中轴的元素都在中轴的右边，
 * 所以扫描会忽略大于中轴的元素，直到遇到第一个小于中轴的元素才会停止。
 *
 * 扫描停止之后会有三中情况， i  > j , i = j , i < j
 * i < j ，则交换数组i和j的值，然后继续扫描，
 * i = j 和 i > j 可以统一处理，j所在的位置就是中轴元素排序后的最终位置
 * 交换中轴元素和j的值， 然后数组被分割称两个待排序的数组， [left, j - 1] [j + 1, right]
 * 递归，继续进行排序
 *
 * 和合并排序不同，合并排序将问题划分成两个子问题是很快的，主要工作在于合并子问题的解
 * 快速排序主要工作在于划分阶段，而不需要再去合并子问题的解。
 * 
 * 合并排序和快速排序都是 分治法 的思想
 *
 * 快速排序是不稳定的
 * 例子： 1 1 0 ， 以第一个元素为中轴，最终第一个1会被交换到最后
 */

public class Quicksort {

    public static void sort(int[] array) {

        sort(array, 0, array.length - 1);

    }

    private static void sort(int[] array, int left, int right) {

        if (left >= right) {
            return ;
        }

        int i = left;
        int j = right;

        // 以array[left]为枢轴
        while (i < j) {

            // 找到比枢轴大的元素，之后要移动到枢轴的右边
            // 注意，i初始值就是left，因此等于 array[left] 的也排除了 ，否则i会停留在left位置
            while (i <= right && array[i] <= array[left]) {
                i++;
            }

            // 找到比枢轴小的元素，之后要移动到枢轴的左边
            while (j >= left && array[j] > array[left]) {
                j--;
            }

            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // j 就是枢轴最终的位置
        int tmp = array[j];
        array[j] = array[left];
        array[left] = tmp;

        sort(array, left, j - 1);
        sort(array, j + 1, right);
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
