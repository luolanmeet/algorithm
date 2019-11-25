package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 * @author cck
 */
public class CombinationSum {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res.clear();
        Arrays.sort(nums);
        method(nums, 0, 0, new Stack<Integer>(), target);
        return res;
    }
    
    private void method(int[] nums, int idx, int sum, Stack<Integer> stack, int target) {
        
        if (sum == target) {
            res.add(new ArrayList<>(stack));
            return ;
        }
        
        // sum + nums[idx] > target 加上nums[idx]都大于 target， 那之后的都会大于target
        if (idx >= nums.length || sum + nums[idx] > target) {
            return ;
        }
        
        stack.push(nums[idx]);
        method(nums, idx, sum + nums[idx], stack, target);
        
        stack.pop();
        method(nums, idx + 1, sum, stack, target);
    }
    
    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(obj.combinationSum(new int[]{2,3,6,7}, 7));
    }
    
}
