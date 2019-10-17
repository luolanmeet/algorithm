package pers;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class SortColors {
    
    public void sortColors(int[] nums) {
    
        int count0 = 0, count1 = 0, count2 = 0;
    
        for (int num : nums)
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        
        int index = 0;
        for (int i = 0; i < count0; i++)
            nums[index++] = 0;
        for (int i = 0; i < count1; i++)
            nums[index++] = 1;
        for (int i = 0; i < count2; i++)
            nums[index++] = 2;
    }
    
    public static void main(String[] args) {
        SortColors obj = new SortColors();
        int[] nums = {2,0,2,1,1,0};
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    
}
