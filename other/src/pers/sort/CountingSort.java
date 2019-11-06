package pers.sort;

import java.util.Arrays;

/**
 * 计数排序，非比较的排序算法
 * 重点是明白算最终位置的逻辑
 */
public class CountingSort {

    public static int[] countSort(int[] array) {

        int max = array[0], min = array[0];
        for (int val : array) {
            if (val > max)
                max = val;
            if (val < min)
                min = val;
        }
        // k空间足够存储 [0,  max - min + 1]
        int k = max - min + 1;
        int count[] = new int[k];

        // 进行计数时，元素值-min 对应到 count 数组的下标
        // 确定每个元素的出现的次数
        for (int i = 0; i < array.length; ++i) {
            count[array[i] - min] += 1;
        }
        // 计算每个元素的最终位置的最大值，
        // count[0] 的元素的最终位置的最大值 是 count[0]，
        //   最小元素的最终位置的最大值就是本身出现的次数
        // count[1] 的元素的最终位置的最大值 是 count[0] + count[1]，
        //   非最小元素的最终位置的最大值就是比自己小的元素的个数加上自己元素的个数
        // count[2] 的元素的最终位置的最大值 是 count[0] + count[1] + count[2]
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        int result[] = new int[array.length];

        // count数组此时存的是对应元素值排序后的位置
        for (int i = 0; i < array.length; i++) {
            // --count[*]，位置往后移动
            result[--count[array[i] - min]] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {5, 1, 1, 2, 0, 0, 0};
        System.out.println(Arrays.toString(countSort(array1)));
        int[] array2 = {10,10,-4,7,5,5,1,1,-1,2,110,20};
        System.out.println(Arrays.toString(countSort(array2)));
    }

}
