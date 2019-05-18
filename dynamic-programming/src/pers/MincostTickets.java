package pers;

/**
 * 983. 最低票价
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/submissions/
 * @author cck
 */
public class MincostTickets {
    
    static int[] freeLen = new int[]{1, 7, 30};
    static Integer[][] dp;
    
    public int mincostTickets(int[] days, int[] costs) {
        
        dp = new Integer[days.length][days.length];
        return method(days, costs, 0, 0);
    }

    private int method(int[] days, int[] costs, int pos, int freeDay) {

        if (pos >= days.length) {
            return 0;
        }
        
        if (freeDay > days[pos]) {
            return method(days, costs, pos + 1, freeDay);
        }
        
        if (pos < days.length - 2 && dp[pos][pos + 1] != null) {
            return dp[pos][pos + 1];
        }
        
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            res = Math.min(costs[j] + method(days, costs, pos + 1, days[pos] + freeLen[j]), res);
        }
        
        if (pos < days.length - 2) {
            dp[pos][pos + 1] = res;
        }
        
        return res;
    }
    
    public int mincostTickets2(int[] days, int[] costs) {
        
        int finalDay = days[days.length-1];
        int[] dp = new int[finalDay+1];  // 这个dp 存的是 到第i天需要的最小的话费
        int j = 0;
        
        for(int i = 1; i <= finalDay; i++){
            
            if(i == days[j]){
                
                int a = dp[i - 1] + costs[0];
                int b = (i > 7 ? dp[i - 7] : 0) + costs[1];  // 7天前的花费，加上七天后，也就是今天的花费（这张票正好用完）
                int c = (i > 30 ? dp[i - 30] : 0) + costs[2];
                
                dp[i] = Math.min(Math.min(a, b), c);
                j++;
                
            } else {
                dp[i] = dp[i-1];
            }
            
        }
        
        return dp[finalDay];
    }
    
    public static void main(String[] args) {
        
        MincostTickets obj = new MincostTickets();
        System.out.println(obj.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
        System.out.println(obj.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
    }
    
}
