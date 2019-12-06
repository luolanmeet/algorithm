package pers;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class GenerateMatrix {

    static final int[] x = new int[]{0, 1, 0, -1};
    static final int[] y = new int[]{1, 0, -1, 0};

    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];

        int val = 1;
        int end = n * n;

        int i = 0, j = 0, idx = 0;

        while (val <= end) {

            res[i][j] = val++;

            if (i+x[idx]>=n || i+x[idx]<0 || j+y[idx]>=n || j+y[idx]<0
                    || res[i+x[idx]][j+y[idx]] != 0) {

                idx++;
                idx %= 4;
            }

            i += x[idx];
            j += y[idx];
        }

        return res;
    }

    public static void main(String[] args) {
        GenerateMatrix obj = new GenerateMatrix();
        int[][] arrays = obj.generateMatrix(5);
        for (int[] array : arrays) {
            System.out.println(Arrays.toString(array));
        }
    }

}
