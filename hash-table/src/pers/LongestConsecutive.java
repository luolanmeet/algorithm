package pers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128.最长连续序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 * @auther ken.ck
 * @date 2024/2/23 19:24
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (Integer num : set) {

            // 跳过中间的数
            if (set.contains(num - 1)) {
                continue;
            }

            int count = 1;
            int tmp = num + 1;
            while (set.contains(tmp)) {
                count++;
                tmp++;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public int longestConsecutive2(int[] nums) {

        // 排序
        Arrays.sort(nums);
        if (nums.length <= 1) {
            return nums.length;
        }

        int pre = nums[0];
        int count = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                continue;
            }
            if (nums[i] == pre + 1) {
                pre = nums[i];
                count++;
                res = Math.max(res, count);
            } else {
                pre = nums[i];
                count = 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestConsecutive obj = new LongestConsecutive();
        System.out.println(obj.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(obj.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

}
