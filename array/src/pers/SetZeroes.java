package pers;

import java.util.Arrays;

/**
 * 73. 矩阵置零
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class SetZeroes {
    
    public void setZeroes(int[][] matrix) {
    
        // 如果 matrix[i][j] 是0， 则把0放到首行和首列，之后遍历首行首列，把对应的行和列置0
        // 这样会丢失首行和首列的信息，所以要先确认首行首列是否有0

        // 首行是否有0
        boolean rowFlag = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }
        // 首列是否有0
        boolean colFlag = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }
        // 遍历除了首行和首列的元素
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        if (rowFlag) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    
        if (colFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        
        SetZeroes obj = new SetZeroes();
    
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}};
        obj.setZeroes(matrix);
        for (int[] tmp : matrix)
            System.out.println(Arrays.toString(tmp));
        System.out.println();
        matrix = new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};
        obj.setZeroes(matrix);
        for (int[] tmp : matrix)
            System.out.println(Arrays.toString(tmp));
    }
    
}
