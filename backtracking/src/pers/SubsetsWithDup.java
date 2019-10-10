package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 90. 子集 II
 * https://leetcode-cn.com/problems/subsets-ii/
 * @author cck
 */
public class SubsetsWithDup {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        backstrck(nums, res, 0, new Stack<Integer>(), true);
        
        return res;
    }
    
    private void backstrck(int[] nums, List<List<Integer>> res, int index, Stack<Integer> stack, boolean isAdd) {
    
        if (isAdd) {
            res.add(new ArrayList<>(stack));
        }
    
        if (index >= nums.length) {
            return ;
        }
        
        // 要index这个数
        stack.push(nums[index]);
        backstrck(nums, res, index+1, stack, true);
        stack.pop();
        
        // 不要index这个数
        for (int i = index + 1; i < nums.length; i++) {
    
            // 去重
            if (nums[index] == nums[i]) {
                continue;
            }
            backstrck(nums, res, i, stack, false);
            break;
        }
    }
    
    public static void main(String[] args) {
        SubsetsWithDup obj = new SubsetsWithDup();
        System.out.println(obj.subsetsWithDup(new int[]{1,2,2}));
    }
    
}
