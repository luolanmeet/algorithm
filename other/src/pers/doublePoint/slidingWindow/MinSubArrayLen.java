package pers.doublePoint.slidingWindow;

/**
 * 209. 长度最小的子数组
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
 * @auther ken.ck
 * @date 2024/2/22 23:16
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int left = 0;
        int right = 0;
        int res = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];
            // 滑动窗口，每次循环右窗口必移动
            right++;

            // 题目是 >= 即可
            while (sum >= target) {
                res = Integer.min(right - left, res);
                sum -= nums[left];
                left++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        MinSubArrayLen obj = new MinSubArrayLen();
        System.out.println(obj.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
        System.out.println(obj.minSubArrayLen(4, new int[] {1,4,4}));
        System.out.println(obj.minSubArrayLen(11, new int[] {1,2,3,4,5}));
    }

}
