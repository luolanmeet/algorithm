package pers;

/**
 * 1312. 让字符串成为回文串的最少插入次数
 * https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 *
 * @author cck
 * @date 2021/1/15 6:45
 */
public class MinInsertions {

    public int minInsertions(String s) {

        int n = s.length();

        // 对于s[i..j]至少需要插入dp[i][j]次才能变成回文串
        int[][] dp = new int[n][n];
        // base case dp[i][i] = 0，单个字符就是回文串，不需要插入

        /**
         * 数学归纳 dp[i][j] = ?
         * s[i] == s[j] 时, dp[i][j] = dp[i+1][j-1]
         * 先使得 s[i+1..j]或s[i..j-1]变为回文字符串，再插入1次，如"aaax"，只需插入一次即可
         * s[i] != s[j] 时, dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1
         */

        /**
         * 遍历方向？
         * 根据base case的情况以及状态转移方程决定遍历方向，
         * i <= j，因此左下方的值不用管，i == j 时，值为0，
         * 推出 dp[i][j] 需要知道 dp[i+1][j-1]， dp[i+1][j]， dp[i][j-1])
         * 因此遍历方向应该是从下到上，从左到右
         *           0  ?  ?  ?  ?
         *           x  0  ?  ?  ?
         *           x  x  0  ?  ?
         *           x  x  x  0  ?
         *           x  x  x  x  0
         */

        // 从下往上
        for (int i = n - 2; i >= 0; i--) {
            // 从左向右
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        MinInsertions obj = new MinInsertions();
        System.out.println(obj.minInsertions("zzazz"));
        System.out.println(obj.minInsertions("mbadm"));
        System.out.println(obj.minInsertions("leetcode"));
        System.out.println(obj.minInsertions("no"));
    }

}
