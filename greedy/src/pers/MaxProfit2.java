package pers;

/**
 * 714. 买卖股票的最佳时机含手续费
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @author Ryan
 */
public class MaxProfit2 {
    
    public int maxProfit(int[] prices, int fee) {

        // 基本思路是，当前遍历到的一天 - 保存的那一天 - fee > 0 ， 就可以做这笔交易
        // 需要特殊处理的地方就是，卖出的那一天是出了手续费的，因此需要减去fee，然后再和之后的数据比较
        
        int res = 0;
        int temp = 0;
        
        for (int i = 0; i < prices.length; i++) {
            
            if (prices[temp] > prices[i]) {
                temp = i;
                continue;
            } 
            
            int val = prices[i] - prices[temp] - fee;
            if (val > 0) {
                res += val;
                temp = i;
                // temp 这个下标的那天已经出过手续费了，是特殊的一天
                prices[temp] -= fee;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        MaxProfit2 obj = new MaxProfit2();
        System.out.println(obj.maxProfit(new int[] {1, 3, 7, 5, 10, 3}, 3));
        System.out.println(obj.maxProfit(new int[] {1, 3, 2, 8, 4, 9}, 2));
    }
    
}
