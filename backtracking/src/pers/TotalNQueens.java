package pers;

/**
 * 52. N皇后 II
 * https://leetcode-cn.com/problems/n-queens-ii/submissions/
 * 性能贼差
 * @author cck
 */
public class TotalNQueens {
    
    int count;
    
    public int totalNQueens(int n) {
        count = 0;
        backtrack(new boolean[n][n], n, n, 0, 0);
        return count;
    }
    
    private void backtrack(boolean[][] qs, int n, int total, int x, int y) {
        
        if (n == 0) {
            count++;
            return;
        }
        
        if (y >= total) {
            backtrack(qs, n, total, x + 1, 0);
            return;
        }
        
        if (x >= total) {
            return ;
        }
        
        // 检查上
        int a = x;
        while (a >= 0) {
            if (qs[a--][y]) {
                backtrack(qs, n, total, x, y + 1);
                return;
            }
        }
        
        // 检查左
        int b = y;
        while (b >= 0) {
            if (qs[x][b--]) {
                backtrack(qs, n, total, x, y + 1);
                return;
            }
        }
        
        // 检查左上
        a = x;
        b = y;
        while (a >= 0 && b >= 0) {
            if (qs[a--][b--]) {
                backtrack(qs, n, total, x, y + 1);
                return;
            }
        }
        
        // 检查右上
        a = x;
        b = y;
        while (a >= 0 && b < total) {
            if (qs[a--][b++]) {
                backtrack(qs, n, total, x, y + 1);
                return;
            }
        }
        
        qs[x][y] = true;
        backtrack(qs, n - 1, total, x, y + 1);
        qs[x][y] = false;
        backtrack(qs, n, total, x, y + 1);
    }
    
    public static void main(String[] args) {
        TotalNQueens obj = new TotalNQueens();
        System.out.println(obj.totalNQueens(4));
    }
    
}
