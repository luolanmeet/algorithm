package pers;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * @auther ken.ck
 * @date 2021/2/8 15:18
 */
public class Rob {

    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        /**
         * 状态
         * 当前房屋数
         */
        /**
         * 选择
         * 偷或不偷
         */
        /**
         * dp数据含义
         * 从1~i，最大能获取多少金额
         */
        int[] dp = new int[nums.length+1];
        // 只有一件房屋，当然是偷的
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        return dp[nums.length];
    }

    public static void main(String[] args) {

        Rob obj = new Rob();
        System.out.println(obj.rob(new int[]{3}));
        System.out.println(obj.rob(new int[]{1,2,3,1}));
        System.out.println(obj.rob(new int[]{2,7,9,3,1}));
    }

}
