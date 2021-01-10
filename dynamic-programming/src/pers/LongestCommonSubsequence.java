package pers;

/**
 * 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * @author cck
 * @date 2021/1/10 19:13
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String s1, String s2) {

        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        System.out.println(obj.longestCommonSubsequence("abc", "abc"));
        System.out.println(obj.longestCommonSubsequence("abc", "def"));
        System.out.println(obj.longestCommonSubsequence("abcde", "ace"));
    }

}
