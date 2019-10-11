package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N皇后
 * https://leetcode-cn.com/problems/n-queens/submissions/
 * @author cck
 */
public class SolveNQueens {
    
    public List<List<String>> solveNQueens(int n) {
    
        List<List<String>> res = new ArrayList<>();
        boolean [][] qs = new boolean[n][n];
        backtrack(res, qs, n, n, 0, 0);
        
        return res;
    }
    
    private void backtrack(List<List<String>> res, boolean[][] qs, int n, int total, int x, int y) {
        
        if (n == 0) {
            List<String> tmp = new ArrayList<>();
            for (boolean[] bs : qs) {
                StringBuilder strBuil = new StringBuilder();
                for (boolean b : bs) {
                    if(b) {
                        strBuil.append("Q");
                    } else {
                        strBuil.append(".");
                    }
                }
                tmp.add(strBuil.toString());
            }
            res.add(tmp);
            return ;
        }
        
        if (y >= total) {
            backtrack(res, qs, n, total, x + 1, 0);
            return;
        }
        
        if (x >= total) {
            return ;
        }
        
        // 检查上
        int a = x;
        while (a >= 0) {
            if (qs[a--][y]) {
                backtrack(res, qs, n, total, x, y + 1);
                return;
            }
        }

        // 检查左
        int b = y;
        while (b >= 0) {
            if (qs[x][b--]) {
                backtrack(res, qs, n, total, x, y + 1);
                return;
            }
        }
        
        // 检查左上
        a = x;
        b = y;
        while (a >= 0 && b >= 0) {
            if (qs[a--][b--]) {
                backtrack(res, qs, n, total, x, y + 1);
                return;
            }
        }

        // 检查右上
        a = x;
        b = y;
        while (a >= 0 && b < total) {
            if (qs[a--][b++]) {
                backtrack(res, qs, n, total, x, y + 1);
                return;
            }
        }
        
        qs[x][y] = true;
        backtrack(res, qs, n - 1, total, x, y + 1);
        qs[x][y] = false;
        backtrack(res, qs, n, total, x, y + 1);
    }
    
    public static void main(String[] args) {
        SolveNQueens obj = new SolveNQueens();
        System.out.println(obj.solveNQueens(4));
    }
    
}
