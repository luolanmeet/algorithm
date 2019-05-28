package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets 
 * https://leetcode-cn.com/problems/subsets/
 * @author cck
 */
public class Subsets {
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        method(nums, 0, res, new ArrayList<Integer>(), true);
        
        return res;
    }

    private void method(int[] nums, int i, List<List<Integer>> res, List<Integer> now, boolean needAdd) {
        
        if (needAdd) {
            res.add(now);
        }
        
        if (i >= nums.length) {
            return ;
        }
        
        List<Integer> now1 = new ArrayList<>(now);
        List<Integer> now2 = new ArrayList<>(now);
        now1.add(nums[i]);
        method(nums, i + 1, res, now1, true);
        method(nums, i + 1, res, now2, false);
    }
    
    public static void main(String[] args) {
        
        Subsets obj = new Subsets();
        System.out.println(obj.subsets(new int[] {1,2,3}));
    }
    
}
