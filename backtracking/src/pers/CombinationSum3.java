package pers;

import java.util.*;

/**
 * 在【40. 组合总和 II】的基础上添加限制，
 * 只允许使用3个数组合出目标值
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        method(candidates, target, res, 0, 0, new Stack<Integer>());

        return res;
    }

    private void method(int[] candidates, int target, List<List<Integer>> res, int idx, int sum, Stack<Integer> stack) {

        if (stack.size() == 3 && sum == target) {
            res.add(new ArrayList<>(stack));
            return ;
        }

        if (idx >= candidates.length || stack.size() >= 3) {
            return ;
        }

        stack.push(candidates[idx]);
        method(candidates, target, res, idx + 1, sum + candidates[idx], stack);
        stack.pop();

        // 去重
        for (int i = idx + 1; i < candidates.length; i++) {

            // 重复值
            if (candidates[i] == candidates[idx]) {
                continue;
            }

            method(candidates, target, res, i, sum, stack);
            break;
        }

    }

    public static void main(String[] args) {

        CombinationSum3 obj = new CombinationSum3();
        System.out.println(obj.combinationSum3(new int[]{10,1,2,1,7,6,1,5}, 8));
        System.out.println(obj.combinationSum3(new int[]{2,5,2,1,2,1}, 5));
        System.out.println(obj.combinationSum3(new int[]{2,2,2,2,2}, 6));
    }

}
