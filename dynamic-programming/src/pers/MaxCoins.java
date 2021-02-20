package pers;

import java.util.Arrays;

/**
 * 312. 戳气球
 * https://leetcode-cn.com/problems/burst-balloons/
 * @auther ken.ck
 * @date 2021/1/30 11:18
 */
public class MaxCoins {

    public int maxCoins2(Integer nums[]) {

        int n = nums.length;
        int[] points = new int[n + 2];
        points[0] = points [n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }

        // base case
        int[][] dp = new int[n + 2][n + 2];

        // 开始状态转移
        // 根据 base case，和最终状态推导出i,j的遍历方向为
        // i从下往上遍历
        for (int i = n; i >= 0; i--) {

            // j从左往右遍历
            for (int j = i + 1; j < n + 2; j++) {

                // 最后戳破的气球是哪个
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]
                    );
                }
            }
        }

        return dp[0][n + 1];
    }

    Integer result = Integer.MIN_VALUE;
    public int maxCoins(Integer nums[]) {

        boolean used[] = new boolean[nums.length];
        backtrack(nums, used, 0);
        return result;
    }

    Integer count = 0;
    private void backtrack(Integer[] nums, boolean[] used, Integer coin) {

        for (int i = 0; i < used.length; i++) {

            if (used[i]) {
                continue;
            }

            // 戳破nums[i]这个气球
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && used[left]) {
                left--;
            }
            while (right < nums.length && used[right]) {
                right++;
            }
            int tempCoin = nums[i];
            if (left >= 0) {
                tempCoin *= nums[left];
            }
            if (right < nums.length) {
                tempCoin *= nums[right];
            }
            used[i] = true;
            printIndent(count++, used, coin + tempCoin);
            backtrack(nums, used, coin + tempCoin);
            count--;

            // 回溯
            // 不戳破nums[i]这个气球
            used[i] = false;
        }

        result = Math.max(result, coin);
    }

    public void printIndent(Integer integer, boolean[] used, int coins) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
        System.out.print("used:" + Arrays.toString(used));
        System.out.println(" coins:" + coins);
    }

    public static void main(String[] args) {
        MaxCoins obj = new MaxCoins();
        Integer[] nums = {1, 2, 3, 4};
        System.out.println(obj.maxCoins(nums));
        System.out.println(obj.maxCoins2(nums));
    }

}
