package pers;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/comments/
 * @author cck
 */
public class CanPartitionKSubsets {
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int temp = 0;
        for (int num : nums) {
            temp += num;
        }
        if (temp % k != 0) {
            return false;
        }
        temp /= k;
        int[] data = new int[k];
        Arrays.sort(nums);
        if(nums[nums.length - 1] > temp){
            return false;
        }
        for (int i = 0; i < k; i++) {
            data[i] = temp;
        }
        
        return method(nums, nums.length - 1, data, k);
    }

    private boolean method(int[] nums, int i, int[] data, int k) {
        
        if (i < 0) {
            for (int a : data) {
                if (a != 0) {
                    return false;
                }
            }
            return true;            
        }
        
        for (int j = 0; j < k; j++) {
            if (data[j] >= nums[i]) {
                data[j] -= nums[i];
                if (method(nums, i-1, data, k)) {
                    return true;
                }
                data[j] += nums[i];
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        
        CanPartitionKSubsets obj = new CanPartitionKSubsets();
        System.out.println(obj.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
    
}
