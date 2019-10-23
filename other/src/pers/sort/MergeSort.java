package pers.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 归并操作的工作原理如下：
 * 第一步：申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 第二步：设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 第三步：比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 重复步骤3直到某一指针超出序列尾
 * 将另一序列剩下的所有元素直接复制到合并序列尾
 */
public class MergeSort {
    
    public static int[] sort(int[] array) {
        return merge(array, 0, array.length - 1);
    }
    
    private static int[] merge(int[] array, int left, int right) {
    
        if (left == right) {
            return new int[]{array[left]};
        }
        
        int mid = left + (right - left) / 2;
        
        int[] lArr = merge(array, left, mid);
        int[] rArr = merge(array, mid + 1, right);
        int[] resArr = new int[lArr.length + rArr.length];
        
        int resArrIndex = 0;
        int lArrIndex = 0;
        int rArrIndex = 0;
        
        while (lArrIndex < lArr.length && rArrIndex < rArr.length) {
            resArr[resArrIndex++] = lArr[lArrIndex] < rArr[rArrIndex] ? lArr[lArrIndex++] : rArr[rArrIndex++];
        }
        
        while (lArrIndex < lArr.length) {
            resArr[resArrIndex++] = lArr[lArrIndex++];
        }
    
        while (rArrIndex < rArr.length) {
            resArr[resArrIndex++] = lArr[rArrIndex++];
        }
        
        return resArr;
    }
    
    public static void main(String[] args) {
        int[] array1 = {5,1,1,2,0,0,0,8};
        System.out.println(Arrays.toString(sort(array1)));
    
        int[] array2 = {10,10,-4,7,5,5,8,1,1,-1,2,110,20,120};
        System.out.println(Arrays.toString(sort(array2)));
    
        int[] array3 = {15,12};
        System.out.println(Arrays.toString(sort(array3)));
    }
    
}
