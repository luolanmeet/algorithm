package pers;

/**
 * 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 * @author cck
 * @date 2021/4/15 22:05
 */
public class Rob2 {

    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        return Math.max(
                rob(nums, 0, nums.length - 1),
                rob(nums, 1, nums.length)
        );
    }

    public int rob(int[] nums, int i, int j) {

        int dp1 = 0;
        int dp2 = 0;
        int dpi = 0;
        while (i < j) {
            dpi = Math.max(nums[i] + dp1, dp2);
            dp1 = dp2;
            dp2 = dpi;
            i++;
        }

        return dpi;
    }

}
