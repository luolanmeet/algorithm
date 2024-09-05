package pers;

/**
 * 2708. 一个小组的最大实力值
 * https://leetcode.cn/problems/maximum-strength-of-a-group/description/
 * @auther ken.ck
 * @date 2024/9/3 14:15
 */
public class MaxStrength {

    public long maxStrength(int[] nums) {

        // dp1[i] 维护[0, i]最大的乘积
        // dp2[i] 维护[0, i]最小的乘积
        long[] dp1 = new long[nums.length];
        long[] dp2 = new long[nums.length];
        dp1[0] = nums[0];
        dp2[0] = nums[0];

        long res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            long tmp1 = dp1[i - 1] * nums[i];
            long tmp2 = dp2[i - 1] * nums[i];

            dp1[i] = Math.max(dp1[i - 1], Math.max(tmp1, tmp2));
            dp1[i] = Math.max(dp1[i], nums[i]);
            res = Math.max(res, dp1[i]);

            dp2[i] = Math.min(dp2[i - 1], Math.min(tmp1, tmp2));
            dp2[i] = Math.min(dp2[i], nums[i]);
        }

        return res;
    }

    /**
     * 状态压缩
     * @param nums
     * @return
     */
    public long maxStrength2(int[] nums) {

        // max 维护[0, i - 1]最大的乘积
        // min 维护[0, i - 1]最小的乘积
        long max = nums[0];
        long min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            long tmp1 = max * nums[i];
            long tmp2 = min * nums[i];

            max = Math.max(max, Math.max(tmp1, tmp2));
            max = Math.max(max, nums[i]);

            min = Math.min(min, Math.min(tmp1, tmp2));
            min = Math.min(min, nums[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxStrength obj = new MaxStrength();
        System.out.println(obj.maxStrength(new int[]{-1,-7,-5,7,7,0,9,0,-5,-6}));
    }

}
