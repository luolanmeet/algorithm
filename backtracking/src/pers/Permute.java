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

        // 写回溯 容易陷入 "要和不要" 这种思维惯性
        // 这里压根不管，能用就用。因为每次这里都是从 0 开始遍历，不存在上次回溯的状态。
        // 假设数组为[1,2,3,4]
        // 第一次的for，处理了以 1、2、3、4 开头的情况
        // 递归进去后的 for 同样处理了以 1、2、3、4 开头的情况，只不过是在上一次 for 的处理的基础上继续处理
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
