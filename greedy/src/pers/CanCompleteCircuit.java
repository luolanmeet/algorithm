package pers;

/**
 * 134. 加油站
 * https://leetcode-cn.com/problems/gas-station/
 * @author cck
 */
public class CanCompleteCircuit {
    
    // 暴力破解
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int len = gas.length;
        
        for (int i = 0; i < len; i++) {
            gas[i] -= cost[i];
        }
        
        TAG:
        for (int i = 0; i < len; i++) {
            
            int left = 0;
            for (int j = 0; j < len; j++) {
                
                left += gas[(i + j) % len];
                
                if (left < 0) {
                    continue TAG;
                }
            }
            
            return i;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        
        CanCompleteCircuit obj = new CanCompleteCircuit();
        System.out.println(obj.canCompleteCircuit(
                new int[]{1,2,3,4,5}, 
                new int[]{3,4,5,1,2}));
        System.out.println(obj.canCompleteCircuit(
                new int[]{2,3,4}, 
                new int[]{3,4,3}));
        
    }
    
}
