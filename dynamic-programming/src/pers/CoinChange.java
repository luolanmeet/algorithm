package pers;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {

    /**
     * dp[i]：当目标金额为i时，至少需要dp[i]枚硬币凑出
     * 子问题数目为O(n)，处理每个子问题时间为O(k)，即时间复杂度为O(nk)
     */
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

    /**
     *
     * base case：金额为0时，返回0
     * 状态：金额会不断接近base case，因此金额是状态
     * 选择：选择硬币会导致状态的改变，因此所有硬币的值，就是选择
     *
     * 子问题数目为O(k^n)，处理每个子问题时间为O(k)，即时间复杂度为O(k * n^k)
     *
     * 暴力破解 <-> 状态转移方程
     *         { 0, n=0
     * dp(n) = { 无解, n<1
     *         { min{dp(n-coin)+1 | coin ∈ coins}, n>0}
     */
    public int coinChangeViolence(int[] coins, int amount) {

        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;

        for (int coin : coins) {

            int tem = coinChangeViolence(coins, amount - coin);
            if (tem < 0) {
                continue;
            }

            res = Math.min(res, tem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {

        CoinChange obj = new CoinChange();

        int[] coins = new int[]{1,2,5};
        int amount = 51;
        System.out.println(obj.coinChange(coins,amount));
        System.out.println(obj.coinChangeViolence(coins,amount));
    }

}
