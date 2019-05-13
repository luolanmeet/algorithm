package pers;

/**
 * 1025. 除数博弈
 * https://leetcode-cn.com/problems/divisor-game/comments/
 * @author cck
 */
public class DivisorGame {

    // dp
    public boolean divisorGame(int N) {
        
        boolean[] dp = new boolean[N + 1];
        
        for (int i = 1; i <= N; i++) {
            for (int j = i / 2; j > 0; j--) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[N];
    }
    
    // 数学归纳法
    public boolean divisorGame2(int N) {
        return N % 2 == 0;
    }
    
    public static void main(String[] args) {
        
        DivisorGame obj = new DivisorGame();
        System.out.println(obj.divisorGame(2)); // true
        System.out.println(obj.divisorGame(3)); // false
    }
    
}
