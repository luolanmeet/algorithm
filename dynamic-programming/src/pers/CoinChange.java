package pers;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {

            for (int coin : coins) {

                if (i - coin < 0) continue;

                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }

        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
