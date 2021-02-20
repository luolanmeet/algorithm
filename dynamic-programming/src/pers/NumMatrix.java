package pers;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * @auther ken.ck
 * @date 2021/2/9 13:54
 */
public class NumMatrix {

    int[][] dp;

    public NumMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            dp = new int[0][0];
            return ;
        }

        /**
         * dp[i][j] 的含义， 从点(0,0)到点(i,j)的和
         *
         * 求 (r1, c1) 到 (r2, c2)之间的和 则为
         * dp[r2][c2] - dp[r2][c1-1] - dp[r1-1][c2] + dp[r1-1][c1-1]
         */
        dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int temSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                temSum += matrix[i][j];
                dp[i][j] += temSum;
                if (i > 0) {
                    dp[i][j] += dp[i-1][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        // dp[r2][c2] - dp[r2][c1-1] - dp[r1-1][c2] + dp[r1-1][c1-1]

        int result = dp[row2][col2];

        if (col1 > 0) {
            result -= dp[row2][col1 - 1];
        }
        if (row1 > 0) {
            result -= dp[row1 - 1][col2];
        }
        if (col1 > 0 && row1 > 0) {
            result += dp[row1 - 1][col1 - 1];
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {1, 0, 3, 0, 5},
                {4, 1, 0, 1, 7}, };
        NumMatrix obj = new NumMatrix(matrix);

        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(0, 2, 2, 4));
    }

}
