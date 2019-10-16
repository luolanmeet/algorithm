package pers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 * 瑞士卷？
 */
public class SpiralOrder {
    
    public List<Integer> spiralOrder(int[][] matrix) {
    
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        
        List<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);
        boolean[][] travel = new boolean[matrix.length][matrix[0].length];
        method(matrix, travel, res, 0, 0, 'd');
        return res;
    }
    
    private void method(int[][] matrix, boolean[][] travel, List<Integer> res, int x, int y, char way) {
    
        if (res.size() == matrix.length * matrix[0].length) {
            return ;
        }

        switch (way) {
            
            case 'd':
                for (; y < matrix[0].length; y++) {
                    if (travel[x][y]) {
                        break;
                    }
                    travel[x][y] = true;
                    res.add(matrix[x][y]);
                }
                method(matrix, travel, res, ++x, --y, 's');
            break;
            
            case 's':
                for (; x < matrix.length; x++) {
                    if (travel[x][y]) {
                        break;
                    }
                    travel[x][y] = true;
                    res.add(matrix[x][y]);
                }
                method(matrix, travel, res, --x, --y, 'a');
            break;
            
            case 'a':
                for (; y >= 0; y--) {
                    if (travel[x][y]) {
                        break;
                    }
                    travel[x][y] = true;
                    res.add(matrix[x][y]);
                }
                method(matrix, travel, res, --x, ++y, 'w');
            break;
            
            case 'w':
                for (; x >= 0; x--) {
                    if (travel[x][y]) {
                        break;
                    }
                    travel[x][y] = true;
                    res.add(matrix[x][y]);
                }
                method(matrix, travel, res, ++x, ++y, 'd');
            break;
            
        }
    }
    
    public static void main(String[] args) {
        SpiralOrder obj = new SpiralOrder();
        System.out.println(obj.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        }));
        System.out.println(obj.spiralOrder(new int[][]{
                {1, 2, 3, 4}
        }));
    }
    
}
