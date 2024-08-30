package pers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 77. 组合
 * https://leetcode.cn/problems/combinations/description/
 */
public class Combine {

    /**
     * 等价于 C n取k
     */
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        method(1, new Stack<>(), res, n, k);
        return res;
    }

    private void method(int i, Stack<Integer> stack, List<List<Integer>> res, int n, int k) {

        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return ;
        }

        if (i > n) {
            return ;
        }

        stack.push(i);
        method(i + 1, stack, res, n, k);

        stack.pop();
        method(i + 1, stack, res, n, k);
    }

    public static void main(String[] args) {

        Combine obj = new Combine();

        List<List<Integer>> lists = obj.combine(4, 2);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
