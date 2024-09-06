package pers;

/**
 * 3176. 求出最长好子序列 I
 * https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-i/description/
 * @auther ken.ck
 * @date 2024/9/6 22:40
 */
public class MaximumLength {

    public int maximumLength(int[] nums, int k) {

        // 参考题解
        // https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-i/solutions/2906687/python3javacgotypescript-yi-ti-shuang-ji-ulga

        // dp[i][j] = 以 nums[i] 结尾的最长序列中，有 j 个数字与其后一个数字不相等 所组成的最大长度
        int[][] dp = new int[nums.length][k + 1];

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            for (int h = 0; h <= k; h++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] == nums[j]) {
                        dp[i][h] = Math.max(dp[i][h], dp[j][h] + 1);
                    } else if (h > 0) {
                        dp[i][h] = Math.max(dp[i][h], dp[j][h - 1] + 1);
                    }
                }
                res = Math.max(dp[i][h], res);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumLength obj = new MaximumLength();
        System.out.println(obj.maximumLength(new int[]{1,2,1,1,3}, 2));
        System.out.println(obj.maximumLength(new int[]{1,2,3,4,5,1}, 0));
        System.out.println(obj.maximumLength(new int[]{20,41,39,36,36}, 0));
    }

}
