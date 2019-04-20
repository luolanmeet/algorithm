package pers;

/**
 * 36. 有效的数独 
 * https://leetcode-cn.com/problems/valid-sudoku/
 * @author cck
 */
public class IsValidSudoku {
    
    /** 
     * 难点在于 怎么一个坐标属于哪个 3*3 的宫格 
     * 看到的别人的解法
     * i / 3 * 3 + j / 3
     * 
     * i / 3 * 3  --> 确定在哪有行的 3 * 3 （一共三行）
     * j / 3      --> 确定在哪一列的 3 * 3 （一共三列）
     */
    public boolean isValidSudoku(char[][] board) {
        
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][10];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][10];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (row[i][num] || col[j][num] || block[i / 3 * 3 + j / 3][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
