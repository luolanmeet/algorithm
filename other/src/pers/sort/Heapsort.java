package pers.sort;

import java.util.Arrays;

/**
 * 堆排序（变治法）
 * 问题实例 -> 更简单的实例|另一种表现|另一个问题的实例 -> 解
 *
 * 堆概念：可以定义为一棵二叉树，且需要满足以下两个条件
 *  1. 树必须是完全二叉树（每一层都是满的，除了最后一层的最后边可能空缺）
 *  2. 满足堆特性，即每一个节点的值都要大于或等于子节点。
 *
 *  一个堆的最大元素就是根节点，通过不断移除根节点
 *  再调整堆，最终可以达到排序的效果。
 */
public class Heapsort {

    public static void sort(int[] array) {

        // 从最后的父节点开始，一直到根节点调整值，构造一个堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }

        // 根节点即是最大值，将根节点换到数组最后，然后重新调整堆
        // 只交换了根节点和最后一个子节点，因此从新的根节点调整即可
        // 最终的数组就是升序排列
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }
    }

    private static void adjustHeap(int[] array, int i, int len) {

        // 父节点要大于子节点 array[i] > array[i*2] array[i*2+1]
        int k = i;
        int tmp = array[i];

        // while(有子节点)
        while (k * 2 + 1 < len) {

            int j = k * 2 + 1;
            // 最大的子节点
            if (j + 1 < len && array[j+1] > array[j]) {
                j++;
            }

            // 不需要调整，直接退出
            if (tmp >= array[j]) {
                break;
            }

            swap(array, k, j);

            // 子节点j的值和父节点k交换了，
            // 现在要看变化后的子节点j作为父节点，是否满足要求
            k = j;
        }

    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
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
