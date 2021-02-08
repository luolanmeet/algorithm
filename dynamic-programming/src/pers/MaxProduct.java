package pers;

/**
 * 152. 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * @auther ken.ck
 * @date 2021/2/8 10:02
 */
public class MaxProduct {

    /**
     * 定义dp[i][j]为 以j为结尾，能得到的最大的乘积（j索引所在的地方必选，这样才能使用前边得出的解）
     * 由于只使用到上一行的值，因此可做状态压缩
     * 这样做超时了
     * 1 1 1
     * x 1 1
     * x x 1
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        /**
         * 状态
         * 目前是第几到第几
         */
        /**
         * 选择
         * 要不要和前面的连在一起
         */
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];

        int result = nums[0];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Math.max(nums[i], Math.max(nums[i] * maxDp[i-1], nums[i] * minDp[i-1]));
            minDp[i] = Math.min(nums[i], Math.min(nums[i] * maxDp[i-1], nums[i] * minDp[i-1]));
            result = Integer.max(result, maxDp[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxProduct obj = new MaxProduct();
        System.out.println(obj.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(obj.maxProduct(new int[]{-1,2,1,1}));
    }

}
