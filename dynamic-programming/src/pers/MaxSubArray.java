package pers;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/submissions/
 * @author cck
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        max = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] + nums[i-1] > nums[i]) {
                nums[i] = nums[i] + nums[i-1];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }
    
    public static void main(String[] args) {
        MaxSubArray obj = new MaxSubArray();
        System.out.println(obj.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
    
}
