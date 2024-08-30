package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 40. 组合总和 II
 * 同 FourSum 18.四数之和
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
    
        Arrays.sort(candidates);
        
        backtrack(res, candidates, new Stack<Integer>(), 0, 0, target);
        
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, int[] candidates, Stack<Integer> stack, int index, int sum, int target) {
    
        if (sum == target) {
            res.add(new ArrayList<>(stack));
            return ;
        }
        
        // 大于，直接退出
        if (index >= candidates.length || sum + candidates[index] > target) {
            return ;
        }

        // 这里是要 candidates[index] 这个数，和这个数相关的组合都在这次调用中产生
        // 每次进入 backtrack 都会使用当前数字
        stack.push(candidates[index]);
        backtrack(res, candidates, stack, index + 1, sum + candidates[index], target);
        stack.pop();
    
        // 假设数组是 1,1,1,1,2
        // 去重的思路：
        // 要一个重复的，然后就不要了【backtrack(1)，下一个数】,【backtrack()，不要1，跳到2开始，产生没有1的组合，2】
        // 然后由要了一个重复的数的那次回溯，来负责要第二个重复的。【backtrack(1,1)，下一个数】,【backtrack(1)，不要1，跳到2开始，产生1,2】
        // 再由要了两个重复的那次回溯来负责要第三个重复的。【backtrack(1,1,1)，下一个数】,【backtrack(1,1)，不要1，跳到2开始，产生1,1,2】
        // 再由要了三个重复的那次回溯来负责要第四个重复的。【backtrack(1,1,1,1)，下一个数，产生1,1,1,1,2】,【backtrack(1,1,1)，不要1，跳到2开始，产生1,1,1,2】
        
        // 去重,不要candidates[index]这个数，并且不要和candidates[index]值一样的数
        for (int i = index + 1; i < candidates.length; i++) {
            
            if (candidates[i] == candidates[index]) {
                continue;
            }
    
            backtrack(res, candidates, stack, i, sum, target);
            break;
        }
    }

    /**
     * 先去重 容易理解一些
     */
    public void backTrack2(List<List<Integer>> res, int[] candidates, Stack<Integer> cur, int idx, int sum, int target) {

        if (sum == target) {
            res.add(new ArrayList<>(cur));
            return ;
        }
        if (idx >= candidates.length || sum + candidates[idx] > target) {
            return ;
        }

        // 去重的思路：
        // 用有重复的数字能构成的组合无非就是： 1个重复的数 2个重复的数 .. n个重复的数
        // 统计当前数字一共有多少个重复的，并在当前循环把所有情况都列出，
        // 回溯时，idx 跳过 n 个数即可

        // 统计当前数字一共有多少个重复的
        int time = 0;
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] == candidates[idx]) {
                time++;
            }
        }
        // 用 candidates[idx] 这个数的所有情况，注意这里 idx 跳过的 time 次，调用 backTrack2 时已经是不同的数字了
        // 1个重复的数 2个重复的数 .. n个重复的数
        int tmpSum = 0;
        for (int i = 0; i < time; i++) {
            cur.push(candidates[idx]);
            tmpSum += candidates[idx];
            backTrack2(res, candidates, cur, idx + time, sum + tmpSum, target);
        }
        // 恢复成不使用 candidates[idx] 的状态
        for (int i = 0; i < time; i++) {
            cur.pop();
        }

        // 不使用 candidates[idx] 的情况
        // 0个重复的数
        backTrack2(res, candidates, cur, idx + time, sum, target);
    }
    
    public static void main(String[] args) {
        CombinationSum2 obj = new CombinationSum2();
        System.out.println(obj.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(obj.combinationSum2(new int[]{2,5,2,1,2}, 5));
        System.out.println(obj.combinationSum2(new int[]{2,2,2}, 2));
        System.out.println(obj.combinationSum2(new int[]{1,1,1,1,2}, 2));
    }
    
}
