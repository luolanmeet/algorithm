package pers;

import java.util.Arrays;

/**
 * 130. 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 */
public class Solve {
    
    /**
     * 与边缘的O相连接的O，最终都还是O
     * 不与边缘的O相连的O，最终变为X
     */
    public void solve(char[][] board) {
    
        if (board == null || board.length == 0) {
            return ;
        }
    
        int m = board.length;
        int n = board[0].length;

        // 遍历第一行和最后一行
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, m, n);
            }
            if (board[m-1][i] == 'O') {
                dfs(board, m - 1, i, m, n);
            }
        }
    
        // 遍历第一列和最后一列
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, m, n);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, i, n - 1, m, n);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int x, int y, int m, int n) {
    
        if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] == 'X' || board[x][y] == '#') {
            return ;
        }
    
        board[x][y] = '#';
        dfs(board, x+1, y, m, n);
        dfs(board, x, y+1, m, n);
        dfs(board, x-1, y, m, n);
        dfs(board, x, y-1, m, n);
    }
    
    public static void main(String[] args) {
    
        Solve obj = new Solve();
        char[][] borad = {
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}};
        obj.solve(borad);
    
        for (int i = 0; i < borad.length; i++) {
            System.out.println(Arrays.toString(borad[i]));
        }
        
    }
    
}
