package pers;

import java.util.Arrays;

/**
 * 48. 旋转图像
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class Rotate {

    /**
     * 从上往下遍历就是结果了，不过不符合原地
     */
    public void rotate(int[][] matrix) {

        // n x n 的正方形，i表示正方形第i圈
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        Rotate obj = new Rotate();
        int[][] rotate = {
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        obj.rotate(rotate);
        for (int[] tmp : rotate) {
            System.out.println(Arrays.toString(tmp));
        }
    }

}
