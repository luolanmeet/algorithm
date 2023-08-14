package pers.doublePoint.slidingWindow;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/
 * @auther ken.ck
 * @date 2023/8/14 23:37
 */
public class LongestSubarray {

    public int longestSubarray(int[] nums) {

        int res = 0;
        int l = 0;
        int r = 0;

        boolean deleted = false;
        while (r < nums.length) {

            if (nums[r] == 1) {
                r++;
                res = Math.max(res, (r - l - (deleted ? 1 : 0)));
                continue;
            }

            if (!deleted) {
                deleted = true;
                r++;
                continue;
            }

            while (nums[l] == 1) {
                l++;
            }
            l++;
            deleted = false;
        }

        // 一定要删除一个元素
        return res == nums.length ? res - 1 : res;
    }

    public static void main(String[] args) {
        LongestSubarray obj = new LongestSubarray();
        System.out.println(obj.longestSubarray(new int[]{1,1,1}));
        System.out.println(obj.longestSubarray(new int[]{1,1,0,1}));
        System.out.println(obj.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }

}
