package pers;

import java.util.HashMap;
import java.util.Map;

/**
 * 887. 鸡蛋掉落
 * https://leetcode-cn.com/problems/super-egg-drop/
 * @author cck
 * @date 2021/1/23 17:33
 */
public class SuperEggDrop {

    Map<String, Integer> memo = new HashMap<>();

    public int superEggDrop2(int K, int N) {

        // dp[1][7] = 7 表示，现在有1个鸡蛋，允许被扔7次
        int[][] dp = new int[K+1][N+1];

        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m-1] + dp[k-1][m-1] + 1;
            }
        }

        return m;
    }

    /**
     * 暴力
     * 可以加上二分搜索优化
     */
    public int superEggDrop1(int K, int N) {

        // 如果只剩下1个鸡蛋，最坏情况就是从第一楼一直尝试到第N楼，鸡蛋才摔碎
        if (K == 1) {
            return N;
        }
        // 第0楼，不需要扔鸡蛋
        if (N == 0) {
            return 0;
        }
        // 备忘录
        String key = K + ":" + N;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) { // 选择在第i楼扔鸡蛋
            res = Integer.min(
                    res, Integer.max( // 取最坏的情况
                        superEggDrop1(K, N - i), // 鸡蛋没碎，变成了：有K个鸡蛋，楼高为N-i的子问题
                        superEggDrop1(K - 1, i - 1) // 鸡蛋碎了变成了：有K-1个鸡蛋，楼高为i-1的子问题
                    ) + 1 // 这里扔了一次
            );
        }

        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        SuperEggDrop obj = new SuperEggDrop();
        System.out.println(obj.superEggDrop1(2, 6));

        System.out.println(obj.superEggDrop2(2, 6));
    }

}
