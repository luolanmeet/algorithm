package pers;

import java.util.Arrays;

/**
 * 1029. 两地调度
 * https://leetcode-cn.com/contest/weekly-contest-133/problems/two-city-scheduling/
 * @author cck
 */
public class TwoCitySchedCost {
    
    /**
     * 贪心算法
     * 将去a地费用明显低于去b地的排列在前
     * 然后前 n 个就是去a地的
     * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) > (b[0] - b[1]) ? 1 : -1;
        });

        int res = 0;
        int count = costs.length / 2;
        for (int i = 0; i < costs.length; i++) {
            
            if (count > 0) {
                res += costs[i][0];
                count--;
            } else {
                res += costs[i][1];
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        
        TwoCitySchedCost obj = new TwoCitySchedCost(); 
        int res = obj.twoCitySchedCost(new int[][]{
            {10,20},
            {30,200},
            {400,50},
            {30,20}
        });
        System.out.println(res);
        
        res = obj.twoCitySchedCost(new int[][]{
            {803,60}, 
            {709,262}, 
            {636,484}, 
            {280,517}, 
            {570,276}, 
            {669,128}, 
            {54,98}, 
            {646,501}, 
            {174,449}, 
            {99,369}, 
            {579,119}, 
            {295,764}, 
            {657,13}, 
            {56,107}, 
            {66,530}, 
            {602,973}, 
            {212,304}, 
            {589,895}, 
            {990,94}, 
            {331,440}, 
            {55,556}, 
            {267,149}, 
            {319,442}, 
            {49,254}, 
            {412,657}, 
            {899,103}, 
            {79,352}, 
            {877,184}, 
            {300,944}, 
            {702,302}, 
            {478,249}, 
            {321,352}, 
            {912,475}, 
            {45,666}, 
            {37,78}, 
            {950,845}
        });
        System.out.println(res);
    }
    
}
