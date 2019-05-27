package pers;

/**
 * 650. 只有两个键的键盘
 * https://leetcode-cn.com/problems/2-keys-keyboard/
 * @author cck
 */
public class MinSteps {

    public int minSteps(int n) {
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        
        for (int i = 1; i <= n; i++) {
            
            for (int j = i / 2; j > 0; j--) {
                
                if (i % j != 0) {
                    continue;
                }
                
                dp[i] = Math.min(i, dp[j] + (i / j));
                break;
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        
        MinSteps obj = new MinSteps();
        System.out.println(obj.minSteps(3));
        System.out.println(obj.minSteps(5));
        System.out.println(obj.minSteps(6));
        System.out.println(obj.minSteps(15));
        System.out.println(obj.minSteps(100));
    }
    
}
