package pers;

/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 * @auther ken.ck
 * @date 2021/2/8 11:20
 */
public class NumDecodings {

    public int numDecodings(String s) {

        /**
         * 状态
         * 当前遍历到哪里
         */
        /**
         * 选择
         * 当前的字符要不要和前边的字符合在一起
         */
        char[] cs = s.toCharArray();
        if (cs[0] == '0') {
            return 0;
        }

        int[] dp = new int[cs.length+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= cs.length; i++) {

            int tmp = (cs[i-2] - '0') * 10 + (cs[i-1] - '0');

            // 当前是0，则一定要和前边的合并
            if (cs[i-1] == '0') {
                if (tmp > 26 || cs[i-2] == '0') {
                    return 0;
                }
                // 解码的可能只有一种，相当于去掉了两个字符
                dp[i] = dp[i - 2];
            } else {
                // 不能解码成字母 前一个字符是0的， 都没法合并
                if (tmp > 26 || cs[i-2] == '0') {
                    dp[i] = dp[i-1];
                } else {
                    // 合并
                    dp[i] = dp[i-1] + dp[i-2];
                }
            }
        }

        return dp[cs.length];
    }

    public static void main(String[] args) {
        NumDecodings obj = new NumDecodings();
        System.out.println(obj.numDecodings("2101"));
        System.out.println(obj.numDecodings("10011"));
    }

}
