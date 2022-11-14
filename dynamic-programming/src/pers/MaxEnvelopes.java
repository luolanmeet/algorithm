package pers;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * @author cck
 * @date 2021/1/10 14:35
 */
public class MaxEnvelopes {

    /**
     * 按照宽度升序排序后，转为和lc 300 是一样的题目
     * 注意如果宽度相同，按照高度降序排列，这样可以避免加入宽度一样的信封
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes.length <= 1) {
            return envelopes.length;
        }

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // 宽度相同时，按高度降序排列，保证同个宽度下只有一个信封被使用
            }
            return a[0] - b[0]; // 按宽度升序排列，把问题降成一维
        });

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < envelopes.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = 1;
        for (int val : dp) {
            max = Math.max(max, val);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxEnvelopes obj = new MaxEnvelopes();
        System.out.println(obj.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
    }

}
