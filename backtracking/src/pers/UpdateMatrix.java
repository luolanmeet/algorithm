package pers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * https://leetcode-cn.com/problems/01-matrix/
 */
public class UpdateMatrix {

    private int[][] vector = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int[][] updateMatrix(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // BFS 的第一层
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = row + col;
                }
            }
        }

        while (!queue.isEmpty()) {

            int[] s = queue.poll();
            // 搜索上下左右
            for (int[] v : vector) {

                int i = s[0] + v[0];
                int j = s[1] + v[1];

                if (i >= 0 && i < row
                    && j >= 0 && j < col
                    &&  matrix[i][j] > matrix[s[0]][s[1]] + 1) {
                    matrix[i][j] = matrix[s[0]][s[1]] + 1;
                    queue.offer(new int[]{i,j});
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        UpdateMatrix obj = new UpdateMatrix();

        int[][] matrix = new int[][]{
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };

        matrix = obj.updateMatrix(matrix);

        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

}
