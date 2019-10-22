package pers.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 把小（大）的元素往前（后）调
 */
public class BubbleSort {

    public static void sort(int[] array) {
        
        // 把最大的往后调
        for (int len = array.length; len > 0; len--) {
            for (int i = 0; i < len - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] array1 = {5,1,1,2,0,0};
        sort(array1);
        System.out.println(Arrays.toString(array1));
    
        int[] array2 = {10,10,-4,7,5,5,1,1,2,110,20};
        sort(array2);
        System.out.println(Arrays.toString(array2));
    
        int[] array3 = {5,3};
        sort(array3);
        System.out.println(Arrays.toString(array3));
    }

}
