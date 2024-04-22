package pers;

import java.util.Arrays;

/**
 * 和  70.爬楼梯 一个思路
 * 记忆化搜索
 * 377. 组合总和 Ⅳ
 * https://leetcode.cn/problems/combination-sum-iv/
 * @auther ken.ck
 * @date 2024/4/22 09:34
 */
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(nums, target, memo);
    }

    private int dfs(int[] nums, int target, int[] memo) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += dfs(nums, target - nums[i], memo);
        }
        memo[target] = res;
        return res;
    }

    public static void main(String[] args) {
        CombinationSum4 obj = new CombinationSum4();
        System.out.println(obj.combinationSum4(new int[]{1, 2}, 10));
    }

}
