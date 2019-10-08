package pers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 * @author cck
 */
public class Permute {
    
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(new Stack<Integer>(), res, used, nums);
        
        return res;
    }
    
    private void backtrack(Stack<Integer> stack,
                           List<List<Integer>> res,
                           boolean[] used,
                           int[] nums) {
        
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
        
            if (used[i]) {
                continue;
            }
        
            used[i] = true;
            stack.push(nums[i]);
            
            backtrack(stack, res, used, nums);
    
            used[i] = false;
            stack.pop();
        }
    }
    
    /*
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        
        int n = nums.length;
        backtrack(n, numsList, res, 0);
        return res;
    }

    private void backtrack(
            int n, 
            List<Integer> numsList, 
            List<List<Integer>> res, 
            int first) {
        
        if (n == first) {
            res.add(new ArrayList<>(numsList));
            return ;
        }
        
        for (int i = first; i < n; i++) {
            Collections.swap(numsList, first, i);
            backtrack(n, numsList, res, first + 1);
            Collections.swap(numsList, first, i);
        }
    }*/
    
    public static void main(String[] args) {
        
        Permute obj = new Permute();
        System.out.println(obj.permute(new int[]{1,2,3}));
    }
    
}
