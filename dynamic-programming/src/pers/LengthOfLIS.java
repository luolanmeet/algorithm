package pers;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author cck
 * @date 2021/1/10 11:55
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = 0;
        for (int val : dp) {
            max = Math.max(max, val);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLIS obj = new LengthOfLIS();
        System.out.println(obj.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(obj.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(obj.lengthOfLIS(new int[]{7,7,7,7,7,}));
    }

}
