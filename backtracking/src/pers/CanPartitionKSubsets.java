package pers;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 * @author cck
 */
public class CanPartitionKSubsets {
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int avg = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > avg) {
            return false;
        }

        // 一共分成 k 份
        int[] data = new int[k];
        Arrays.fill(data, avg);

        return method(nums, nums.length - 1, data);
    }

    private boolean method(int[] nums, int idx, int[] data) {
        
        if (idx < 0) {
            for (int a : data) {
                if (a != 0) {
                    return false;
                }
            }
            return true;
        }
        
        for (int i = 0; i < data.length; i++) {
            if (data[i] >= nums[idx]) {
                // 将 nums[idx] 放在第 i 份中
                data[i] -= nums[idx];
                // 存在能分配成功的情况，直接返回。
                if (method(nums, idx - 1, data)) {
                    return true;
                }
                // 回溯
                data[i] += nums[idx];
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        
        CanPartitionKSubsets obj = new CanPartitionKSubsets();
        System.out.println(obj.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
    
}
