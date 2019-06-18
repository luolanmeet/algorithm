package pers;

import java.util.HashSet;
import java.util.Set;

/**
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * @author cck
 */
public class CanPartition {
    
    public boolean canPartition(int[] nums) {
        
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        
        if (target % 2 != 0) {
            return false;
        }
        target /= 2;
       
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < nums.length; i++) {
            
            int temp = target - nums[i];
            if (set.contains(temp)) {
                return true;
            }
            
            Set<Integer> newSet = new HashSet<>();
            for (Integer num : set) {
                newSet.add(num);
                newSet.add(num + nums[i]);
            }
            newSet.add(nums[i]);
            set = newSet;
        }
        
        return set.contains(target);
    }
    
    public boolean canPartition2(int[] nums) {
        
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        
        if((sum & 1) != 0){
            return false;
        }
        
        boolean[] dp = new boolean[(sum >> 1) + 1];
        dp[0] = true;
        
        for(int i = 0; i < nums.length; i++){
            
            for(int j = dp.length - 1; j >= nums[i]; j--) {
                
                if(dp[j - nums[i]]) {
                    dp[j] = true;
                }
            }
        }
        
        return dp[dp.length - 1];
    }
    
    public static void main(String[] args) {
        
        CanPartition obj = new CanPartition(); 
//        System.out.println(obj.canPartition(new int[]{1,1,2,5,5,5,5}));
//        System.out.println(obj.canPartition(new int[]{1, 5, 11, 5}));
//        System.out.println(obj.canPartition(new int[]{1, 2, 3, 5}));
//        System.out.println(obj.canPartition(new int[]{1, 4, 2, 3, 1, 4, 5, 8}));
        System.out.println(obj.canPartition2(new int[]{1, 4, 2, 3, 1, 4, 5, 8}));
    }
    
}
