package pers;

/**
 * 72. 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 * @author cck
 * @date 2021/1/11 23:23
 */
public class MinDistance {

    public int minDistance(String s1, String s2) {

        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        MinDistance obj = new MinDistance();
        System.out.println(obj.minDistance("horse", "ros"));
        System.out.println(obj.minDistance("intention", "execution"));
    }

}
