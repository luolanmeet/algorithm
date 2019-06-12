package pers;

/**
 * 516. 最长回文子序列
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/comments/
 * @author cck
 */
public class LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {

        int len = s.length();
        int[] dp = new int[len];
        char[] cs = s.toCharArray();
        
        for (int j = 0; j < len; j++) {
            
            dp[j] = 1;
            int max = 0;
            
            for (int i = j - 1; i >= 0; i--) {
                int temp = dp[i];
                if (cs[i] == cs[j]) {
                    dp[i] = max + 2;
                }
                max = Math.max(temp, max);
            }
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    
    public int longestPalindromeSubseq2(String s) {
        
        char[] cs = s.toCharArray();
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        
        // dp[i][j]表示子序列s[i...j]最长回文子串长度
        int[][] dp = new int[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            
            dp[i][i] = 1;
            
            for (int j = i + 1; j < n; j++) {
                
                if (cs[i] == cs[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[0][n - 1];
    }

    public int longestPalindromeSubseq3(String s) {

        int len = s.length();
        if (len == 0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        
        // 存储从dp[i][j]，存储从j到i的最大结果
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            
            dp[i][i] = 1;
            
            for (int j = i - 1; j >= 0; j--) {
                
                if (cs[i] == cs[j]) {
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }
        
        return dp[len - 1][0];
    }
    
    public static void main(String[] args) {
        
        LongestPalindromeSubseq obj = new LongestPalindromeSubseq();
        System.out.println(obj.longestPalindromeSubseq("bbbab"));
        System.out.println(obj.longestPalindromeSubseq2("bbbab"));
        System.out.println(obj.longestPalindromeSubseq3("bbbab"));
    }

}
