package pers;

/**
 * 3176. 求出最长好子序列 I
 * https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-i/description/
 * 回溯超时了
 * @auther ken.ck
 * @date 2024/9/6 22:40
 */
public class MaximumLength {

    int res = 0;

    public int maximumLength(int[] nums, int k) {
        res = 0;
        for (int i = 0; i < nums.length; i++) {
            backTrack(nums, k, i, i, 0);
        }
        return res;
    }

    private void backTrack(int[] nums, int k, int idx, int preIdx, int len) {

        res = Math.max(len, res);

        if (idx >= nums.length) {
            return ;
        }

        // 相同，则一定需要 nums[idx]
        if (nums[idx] == nums[preIdx]) {
            backTrack(nums, k, idx + 1, preIdx, len + 1);
            return ;
        }

        // 要nums[idx]，但次数减少
        if (k > 0) {
            backTrack(nums, k - 1, idx + 1, idx, len + 1);
        }

        // 不要 nums[idx]
        backTrack(nums, k, idx + 1, preIdx, len);
    }

    public static void main(String[] args) {
        MaximumLength obj = new MaximumLength();
        System.out.println(obj.maximumLength(new int[]{1,2,1,1,3}, 2));
        System.out.println(obj.maximumLength(new int[]{1,2,3,4,5,1}, 0));
        System.out.println(obj.maximumLength(new int[]{20,41,39,36,36}, 0));
    }

}
