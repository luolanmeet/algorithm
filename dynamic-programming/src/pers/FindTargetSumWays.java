package pers;

/**
 * 494. 目标和
 * https://leetcode-cn.com/problems/target-sum/
 * @auther ken.ck
 * @date 2021/2/11 11:56
 */
public class FindTargetSumWays {

    /**
     * 转为背包问题
     * 把nums分为两个子集A和B，分别代表分配 + 和 - 的数，那么它们和target的关系如下：
     *  sum(A) - sum(B) = target
     *  sum(A) = sum(B) + target
     *
     *  sum(A) + sum(A) = sum(A) + sum(B) + target
     *  2 * sum(A) = sum(nums) + target
     *  sum(A) = (sum(nums) + target) / 2
     *
     *  问题变为， 有一个背包，容量为sum，现在有N个物品，第i个物品的重量为nums[i]
     *  每个物品有且只有一个，请问有多少种方式填满背包
     */
    public int findTargetSumWays(int[] nums, int S) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 不符合的情况
        if (((sum + S) & 1) == 1 || sum < S) {
            return 0;
        }

        int target = (sum + S) / 2;

        // dp数组的含义：用0~i个物品，填满容量为j的背包，一共有多少种方式
        int[][] dp = new int[nums.length + 1][target + 1];
        // 背包容量为0，只有一种方式，就是不装
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                // 能不能装得下
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[nums.length][target];
    }

    public static void main(String[] args) {
        FindTargetSumWays obj = new FindTargetSumWays();
        System.out.println(obj.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1));
    }

}
