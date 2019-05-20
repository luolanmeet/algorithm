package pers;

/**
 * 1049. 最后一块石头的重量 II
 * https://leetcode-cn.com/problems/last-stone-weight-ii/
 * @author cck
 */
public class LastStoneWeightII {

    // 将石头分成最重量接近的两堆，然后结果就是 两堆石头重量 的差值
    public int lastStoneWeightII(int[] stones) {

        // dp 存储一堆石头可能的重量
        boolean[] dp = new boolean[1501];
        dp[0] = true;
        
        int sum = 0;
        
        for (int stone : stones) {
            
            sum += stone;
            for (int i = sum; i >= stone; i--) {
                dp[i] |= dp[i - stone];
            }
            
        }
        
        // i 等于一堆石头的重量，  sum - i 等于另一堆的重量
        // sum - i - i 就是两堆石头重量的差
        for (int i = sum / 2; i > 0; i--) {
            if (dp[i]) {
                return sum - i - i;
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        
        LastStoneWeightII obj = new LastStoneWeightII();
        System.out.println(obj.lastStoneWeightII(new int[]{2,7,4,1,8,1}));
    }
    
}
