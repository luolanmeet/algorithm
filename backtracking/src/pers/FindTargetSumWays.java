package pers;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. 目标和
 * https://leetcode-cn.com/problems/target-sum/
 * @auther ken.ck
 * @date 2021/2/11 09:20
 */
public class FindTargetSumWays {

    Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int S) {
        return backtrack(nums, S,0, 0);
    }

    private int backtrack(int[] nums, int target, int idx, int sum) {

        if (idx >= nums.length) {
            return target == sum ? 1 : 0;
        }

        String key = idx + "#" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // 存在重叠子问题，如 nums[idx] = 0
        int count =
                backtrack(nums, target, idx + 1, sum + nums[idx]) +
                backtrack(nums, target, idx + 1, sum - nums[idx]);
        memo.put(key, count);

        return count;
    }

    public static void main(String[] args) {

        FindTargetSumWays obj = new FindTargetSumWays();
        System.out.println(obj.findTargetSumWays(new int[]{1,3,1,4,2}, 5));
    }

}
