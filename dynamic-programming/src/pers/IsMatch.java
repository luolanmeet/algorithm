package pers;

/**
 * 10. 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * @author cck
 * @date 2021/1/15 7:16
 */
public class IsMatch {

    /**
     * 看的官方题解
     */
    public boolean isMatch(String s, String p) {

        // dp[i][j]  ->  p[0..j] 是否能匹配 s[0..i]
        // 这里可能会有疑惑，不是不匹配就能直接返回false了吗，因为有*的存在，所以不是的 a* ,可以匹配任意个a字符
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 空串是相等的
        dp[0][0] = true;
        // i从0开始，是因为s可能是空串
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0)
            return false;
        if (p.charAt(j-1) == '.')
            return true;
        return s.charAt(i-1) == p.charAt(j-1);
    }

    public static void main(String[] args) {
        IsMatch obj = new IsMatch();
        System.out.println(obj.isMatch("aa", "a*"));
        System.out.println(obj.isMatch("aab", "c*a*b"));
        System.out.println(obj.isMatch("mississippi", "mis*is*p*."));
    }

}
