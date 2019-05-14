package pers;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @author cck
 */
public class ClimbStairs {
    
    public int climbStairs(int n) {
        
        if (n <= 0) {
            return 0;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        // dp[n] = dp[n -1] + dp[n - 2];  斐波那契数列？
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        
        ClimbStairs obj = new ClimbStairs();
        System.out.println(obj.climbStairs(2));
        System.out.println(obj.climbStairs(3));
        System.out.println(obj.climbStairs(4));
        System.out.println(obj.climbStairs(5));
    }
    
}
