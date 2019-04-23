package pers;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author cck
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        
        int min = prices[0];
        int profix = 0;
        
        for (int i = 0; i < prices.length; i++) {
            
            if (min > prices[i]) {
                min = prices[i];
            } else {
                profix += prices[i] - min;
                min = prices[i];
            }
        }
        
        return profix;
    }
    
    public static void main(String[] args) {
        MaxProfit obj = new MaxProfit();
        System.out.println(obj.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(obj.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(obj.maxProfit(new int[]{7,6,4,3,1}));
    }
    
}
