package pers;

import java.util.*;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/submissions/
 */
public class PermuteUnique {
    
    /**
     * 全排列 + 剪枝
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, used, nums, new Stack<Integer>());
        return res;
    }
    
    private void backtrack(List<List<Integer>> res,
                           boolean[] used,
                           int[] nums,
                           Stack<Integer> stack) {
        
        // 得到其中一个解（叶子节点）
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return ;
        }
    
        // 剪枝
        Set<Integer> set = new HashSet<>(nums.length);
    
        for (int i = 0; i < nums.length; i++) {
        
            if (used[i] || set.contains(nums[i])) {
                continue;
            }
        
            set.add(nums[i]);
            stack.push(nums[i]);
            used[i] = true;
            
            backtrack(res, used, nums, stack);
            
            stack.pop();
            used[i] = false;
        }
    
    }
    
    public static void main(String[] args) {
        PermuteUnique obj = new PermuteUnique();
        System.out.println(obj.permuteUnique(new int[]{1,1,2}));
    }
    
}
