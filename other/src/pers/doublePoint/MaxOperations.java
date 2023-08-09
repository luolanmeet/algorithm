package pers.doublePoint;

import java.util.Arrays;

/**
 * 1679. K 和数对的最大数目
 * https://leetcode.cn/problems/max-number-of-k-sum-pairs/
 */
public class MaxOperations {

    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;

        int res = 0;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                res++;
                i++;
                j--;
                continue;
            }
            if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxOperations obj = new MaxOperations();
        System.out.println(obj.maxOperations(new int[]{1,2,3,4}, 5));
        System.out.println(obj.maxOperations(new int[]{3,1,3,4,3}, 6));
    }

}
