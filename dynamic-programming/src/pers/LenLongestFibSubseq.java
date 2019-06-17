package pers;

import java.util.HashMap;
import java.util.Map;

/**
 * 873. 最长的斐波那契子序列的长度
 * https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/comments/
 * @author cck
 */
public class LenLongestFibSubseq {
    
    public int lenLongestFibSubseq(int[] A) {
        
        // dp[i][j]， i到j最长的长度，在同一斐波那契数列中，i和j是相邻的
        int[][] dp = new int[A.length][A.length];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        
        int max = 0;
        
        for (int i = 2; i < A.length; i++) {
            
            for (int j = i - 1; j >= 0; j--) {
                
                int diff = A[i] - A[j];
                
                Integer index = map.get(diff);
                if (index != null && index < j) {
                    dp[i][j] = dp[j][index] + 1;
                    max = Integer.max(dp[i][j], max);
                }
            }
        }
        
        return max == 0 ? 0 : max + 2;
    }
    
    public static void main(String[] args) {
        LenLongestFibSubseq obj = new LenLongestFibSubseq();
        System.out.println(obj.lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(obj.lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
    }
    
}
