package pers.doublePoint;

import java.util.Arrays;

/**
 * 80. 删除有序数组中的重复项 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/
 * @auther ken.ck
 * @date 2024/9/10 17:19
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }
        // slow 是最后一个有效的元素的下标 + 1
        int slow = 2;
        int fast = 2;
        while (fast < nums.length) {

            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

    public static void main(String[] args) {
        RemoveDuplicates obj = new RemoveDuplicates();
        int[] param = new int[]{1,1,1,2,2,3};
        System.out.println(obj.removeDuplicates(param));
        System.out.println(Arrays.toString(param));
    }

}
