package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 40. 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/submissions/
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

        // 这里是要 candidates[index] 这个数
        stack.push(candidates[index]);
        backtrack(res, candidates, stack, index + 1, sum + candidates[index], target);
        stack.pop();
    
        // 做了去重
        // 这里是不要 candidates[index] 这个数，并且不要和 candidates[index] 值一样的数
        for (int i = index + 1; i < candidates.length; i++) {
            
            if (candidates[i] == candidates[index]) {
                continue;
            }
    
            backtrack(res, candidates, stack, i, sum, target);
            break;
        }
    }
    
    public static void main(String[] args) {
        CombinationSum2 obj = new CombinationSum2();
        System.out.println(obj.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(obj.combinationSum2(new int[]{2,5,2,1,2}, 5));
        System.out.println(obj.combinationSum2(new int[]{2,2,2}, 2));
    }
    
}
