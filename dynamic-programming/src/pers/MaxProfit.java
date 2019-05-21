package pers;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/
 * @author cck
 */
public class MaxProfit {
    
    public int maxProfit(int[] prices) {
        
        if (prices.length <= 1) {
            return 0;
        }
        if (prices.length == 2) { 
            return Math.max(prices[1] - prices[0], 0);
        }
        
        int[] dp = new int[prices.length];
        dp[0] = 0;
        
        for (int i = 1; i < prices.length; i++) {
            
            dp[i] = dp[i - 1];
            
            for (int j = i - 1; j >= 0; j--) {
                
                int diff = prices[i] - prices[j];
                if (diff <= 0) {
                    continue;
                }
                
                if (j >= 2) {
                    dp[i] = Math.max(dp[i], dp[j - 2] + diff);
                } else {
                    dp[i] = Math.max(dp[i], diff);
                }
            }
        }
        
        return dp[prices.length - 1];
    }
    
    public static void main(String[] args) {
        
        MaxProfit obj = new MaxProfit();
        System.out.println(obj.maxProfit(new int[]{1,2,3,0,2}));
    }
    
}
