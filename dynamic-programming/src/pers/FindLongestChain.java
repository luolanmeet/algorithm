package pers;

import java.util.Arrays;

/**
 * 646. 最长数对链
 * https://leetcode-cn.com/problems/maximum-length-of-pair-chain/
 * @author cck
 */
public class FindLongestChain {
    
    public int findLongestChain(int[][] pairs) {
        
        // (a, b) 按照a， b 升序排列
        Arrays.sort(pairs, (p1, p2) -> {
            return p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0];
        });
        
        int len = pairs.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < len; i++) {
            
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        
        return dp[len - 1];
    }
    
    public static void main(String[] args) {
        
        FindLongestChain obj = new FindLongestChain();
        System.out.println(obj.findLongestChain(new int[][]{{1,2},{2,3},{3,4}}));
        System.out.println(obj.findLongestChain(new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}}));
    }
    
}
