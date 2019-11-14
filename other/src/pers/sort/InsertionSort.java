package pers.sort;

import java.util.Arrays;

/**
 * 插入排序
 * ⒈ 从第一个元素开始，该元素可以认为已经被排序
 * ⒉ 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * ⒊ 如果该元素（已排序）大于新元素，将该元素移到下一位置
 * ⒋ 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * ⒌ 将新元素插入到下一位置中
 * ⒍ 重复步骤2~5
 *
 * 插入排序是稳定的
 *
 * 如果比较操作的代价比交换操作大的话，可以采用二分查找法来减少比较操作的数目。
 * 该算法可以认为是插入排序的一个变种，称为二分查找排序。
 */
public class InsertionSort {
    
    public static void sort(int[] array) {
        
        for (int i = 0; i < array.length; i++) {
        
            for (int j = i + 1; j < array.length; j++) {
            
                if (array[j] >= array[i]) {
                    continue;
                }
                
                // 把新的元素插入到已经排序好的序列中
                int tmpIndex = j;
                while (tmpIndex > 0) {
                    
                    if (array[tmpIndex] >= array[tmpIndex-1]) {
                        break;
                    }
                    
                    int tmpVal = array[tmpIndex];
                    array[tmpIndex] = array[tmpIndex-1];
                    array[tmpIndex-1] = tmpVal;
                    tmpIndex--;
                }
            }
        
        }
    }
    
    public static void main(String[] args) {
        int[] array1 = {5,1,1,2,0,0,0};
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
