package pers;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange {
    
    /**
     * 二分查找后，往前或往后找
     */
    public int[] searchRange(int[] nums, int target) {
    
        int index = Arrays.binarySearch(nums, target);
        int[] res = new int[]{-1, -1};
        if (index < 0) {
            return res;
        }
        
        int left = index;
        int right = index;
        
        while (left > 0 && nums[left - 1] == target) {
            left--;
        }
        while (right < nums.length - 1 && nums[right + 1] == target) {
            right++;
        }
        
        res[0] = left;
        res[1] = right;
    
        return res;
    }
    
    public static void main(String[] args) {
        SearchRange obj = new SearchRange();
        System.out.println(Arrays.toString(obj.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(obj.searchRange(new int[]{5,7,7,8,8,10}, 6)));
    }
    
}
