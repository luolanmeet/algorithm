package pers;

/**
 * 518. 零钱兑换 II
 * https://leetcode-cn.com/problems/coin-change-2/
 * @author cck
 * @date 2021/2/1 23:05
 */
public class Change {

    /**
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     * 完全背包问题：有一个背包，最大容量为amount，有一些列的物品coins，每个物品重量为coins[i]，每个物品数量无限。
     * 问有多少种方法，能恰好把背包填满
     */
    public int change(int amount, int[] coins) {

        // dp[i][j] = 从0到i的硬币中，能够凑成总金额为j的次数
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i-1] >= 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[coins.length][amount];
    }

}
