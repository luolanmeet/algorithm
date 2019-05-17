package pers;

/**
 * 931. 下降路径最小和
 * https://leetcode-cn.com/problems/minimum-falling-path-sum/comments/
 * @author cck
 */
public class MinFallingPathSum {
    
    public int minFallingPathSum(int[][] A) {
        
        int len = A.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[0][i] = A[0][i];
        }
        
        for (int i = 1; i < len; i++) {
            
            for (int j = 0; j < len; j++) {
                
                int add = dp[i-1][j];
                
                if (j - 1 >= 0) {
                    add = Math.min(add, dp[i-1][j-1]);
                }
                if (j + 1 < len) {
                    add = Math.min(add, dp[i-1][j+1]);
                }
                dp[i][j] = A[i][j] + add;
            }
        }
        
        int res = dp[len-1][0];
        for (int i = 0; i < len; i++) {
            res = Math.min(res, dp[len-1][i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        MinFallingPathSum obj = new MinFallingPathSum();
        System.out.println(obj.minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
    
}
