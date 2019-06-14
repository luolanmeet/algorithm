package pers;

/**
 * 718. 最长重复子数组
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/comments/
 * @author cck
 */
public class FindLength {
    
    public int findLength(int[] A, int[] B) {
        
        int len1 = A.length;
        int len2 = B.length;
        
        // dp[i][j] 存储以 A[i]结尾， B[j]结尾的公共字符串的长度
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        int res = 0;
        for (int i = 1; i <= len1; i++) {
            
            for (int j = 1; j <= len2; j++) {
                
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(dp[i][j], res);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return res;
    }
    
    public static void main(String[] args) {
        
        FindLength obj = new FindLength();
        System.out.println(obj.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }
    
}
