package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/submissions/
 * @author cck
 */
public class CombinationSum {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        method(res, candidates, 0, 0, new ArrayList<Integer>(), target);
        return res;
    }

    private void method(
            List<List<Integer>> res, int[] candidates, 
            int index, int sum, List<Integer> now, int target) {
        
        if (sum == target) {
            res.add(new ArrayList<>(now));
            return ;
        }
        if (sum > target || index >= candidates.length) {
            return ;
        }

        // 不使用candidates[index] 这个数字
        method(res, candidates, index + 1, sum, new ArrayList<>(now), target);
        List<Integer> temp = new ArrayList<>(now);
        
        while (sum < target) {
            temp.add(candidates[index]);
            sum += candidates[index];
            method(res, candidates, index + 1, sum, temp, target);
        }
    }
    
    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(obj.combinationSum(new int[]{2,3,6,7}, 7));
    }
    
}
