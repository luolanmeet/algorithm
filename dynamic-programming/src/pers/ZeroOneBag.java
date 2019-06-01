package pers;

/**
 * 01背包
 * @author cck
 */
public class ZeroOneBag {
    
    /**
     * 有n个物品，它们有各自的体积和价值，现有给定容量的背包，如何让背包里装入的物品具有最大的价值总和？
     * @param w 物品重量
     * @param v 物品价值
     * @param capacity 背包容量
     * @return
     */
    public int maxVal(int[] w, int[] v, int capacity) {
        
        // w和v第0位都为 0
        
        // dp[i][j] 第1~i个物品时，背包容量为j的最大价值
        int[][] dp = new int[w.length+1][capacity+1];
        
        for (int i = 1; i < w.length; i++) {
            
            for (int j = 1; j <= capacity; j++) {
                
                if (w[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 要或者不要第i个物品
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
                }
            }
        }
        
        return dp[w.length-1][capacity];
    }
    
    public static void main(String[] args) {
        
        ZeroOneBag obj = new ZeroOneBag();
        System.out.println(obj.maxVal(new int[]{0,2,3,4,5}, new int[]{0,3,4,5,6}, 8));
        System.out.println(obj.maxVal(new int[]{0,1,2,3,4,5}, new int[]{0,5,4,3,2,1}, 10));
    }
    
}
