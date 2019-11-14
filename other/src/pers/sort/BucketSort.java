package pers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 * 划分的时候其实没有破坏稳定性，
 * 但最后选择什么排序算法是会影响稳定性的
 */
public class BucketSort {

    public static void sort(int[] array) {

        int max = array[0];
        int min = array[0];
        for (int val : array) {
            if (max < val) max = val;
            if (min > val) min = val;
        }

        // 确定桶个数，以10作为值域进行划分
        int bucketCount = max / 10 - min / 10 + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        int tmp = min / 10;
        // 往桶中添加数据
        for (int val : array) {
            buckets.get(val / 10  - tmp).add(val);
        }

        // 直接用List返回结果也好
        int index = 0;
        for (List<Integer> bucket : buckets) {
            // 对桶中的元素进行排序
            Collections.sort(bucket);
            for (int val : bucket) {
                array[index++] = val;
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
