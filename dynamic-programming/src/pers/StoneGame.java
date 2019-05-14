package pers;

/**
 * 877. 石子游戏
 * https://leetcode-cn.com/problems/stone-game/
 * @author cck
 */
public class StoneGame {
    
    public boolean stoneGame(int[] piles) {
        
        int n = piles.length;
        
        // dp[i][j]代表从i到j所能获得的最大的绝对分数
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        
        // size 表示跨度，
        // 跨度1，构造 [0,1][1,2]..[n-2,n-1]的数据，此时使用到了初始的数据
        // 跨度2，构造 [0,3][1,3]..[n-3,n-1]的数据，此时使用到了跨度1构造的数据
        // ...
        for (int size = 1; size < n; size++) {
            
            for (int i = 0; i < n - size; i++) {
                dp[i][i + size] = Math.max(piles[i] - dp[i + 1][i + size], piles[i + size] - dp[i][i + size - 1]);
            }
        }
        
        return dp[0][n - 1] > 0;
    }
    
    public static void main(String[] args) {
        
        StoneGame obj = new StoneGame();
        System.out.println(obj.stoneGame(new int[] {5,3,4,5}));
    }
    
}
