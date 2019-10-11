package pers;

import java.util.Arrays;

/**
 * 37. 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/submissions/
 * @author cck
 */
public class SolveSudoku {
    
    public void solveSudoku(char[][] board) {

        boolean[][] b1 = new boolean[9][10];
        boolean[][] b2 = new boolean[9][10];
        boolean[][] b3 = new boolean[9][10];
    
        // 遍历数独行，构造 boolean 数组
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // 第i行，已经存在了 board[i][j] 这个数
                    b1[i][board[i][j] - '0'] = true;
                    // 第calc(i, j)个 3 * 3矩阵中，已经存在了 board[i][j] 这个数
                    b3[calc(i, j)][board[i][j] - '0'] = true;
                }
                if (board[j][i] != '.') {
                    // 第i列，已经存在了 board[j][i] 这个数
                    b2[i][board[j][i] - '0'] = true;
                }
            }
        }
    
        backtrack(b1, b2, b3, 0, 0, board);
    }
    
    /**
     * 从左往右，从上往下填
     */
    private boolean backtrack(boolean[][] b1, boolean[][] b2, boolean[][] b3, int x, int y, char[][] board) {

        if (y > 8) {
            return backtrack(b1, b2, b3, x + 1, 0, board);
        }
        
        if (x > 8) {
            return true;
        }

        if (board[x][y] != '.') {
            return backtrack(b1, b2, b3, x, y + 1, board);
        }
    
        // 选择1-9填入
        for (int num = 1; num <= 9; num++) {
        
            if (b1[x][num] || b2[y][num] || b3[calc(x, y)][num]) {
                continue;
            }

            b1[x][num] = true;
            b2[y][num] = true;
            b3[calc(x, y)][num] = true;
            board[x][y] = (num + "").charAt(0);
            if (backtrack(b1, b2, b3, x, y + 1, board)) {
                return true;
            }
            board[x][y] = '.';
            b1[x][num] = false;
            b2[y][num] = false;
            b3[calc(x, y)][num] = false;
        }
        
        return false;
    }
    
    private int calc(int i, int j) {
        return i / 3 * 3 + j / 3;
    }
    
    public static void main(String[] args) {
    
        char[][] board ={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        
        SolveSudoku obj = new SolveSudoku();
        obj.solveSudoku(board);
        
        for (char[] cs : board) {
            System.out.println(Arrays.toString(cs));
        }
        
    }
    
}
