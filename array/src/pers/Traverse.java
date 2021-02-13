package pers;

/**
 * 二位数组的遍历（仅限 n * n 矩阵）
 * 通常动态规划，通常会遍历dp数组，根据已知的子问题解得出更大的问题的解。
 * 不同的题对dp数组的遍历有不同的要求。
 *
 * @auther ken.ck
 * @date 2021/2/13 13:13
 */
public class Traverse {

    /**

             1  ?  ?  ?  ?
             0  1  ?  ?  ?
             0  0  1  ?  ?
             0  0  0  1  ?
             0  0  0  0  1

             a ?
               b
           假设 【a和b推出?】，因此需要【→ ↘遍历】或【↑ →遍历】
           最大回文子串
     */

    public static void 从下往上且从左往右(int[][] dp) {
        int n = dp.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                System.out.printf("%2d ", dp[i][j]);
            }
            System.out.println();
        }
    }

    public static void 从左往右斜向下遍历(int[][] dp) {
        int n = dp.length;
        for (int step = 1; step < n; step++) {
            for (int i = 0; i + step < n; i++) {
                System.out.printf("%2d ", dp[i][i+step]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] dp = new int[][]{
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };

        从下往上且从左往右(dp);
        System.out.println();
        从左往右斜向下遍历(dp);
    }

}
