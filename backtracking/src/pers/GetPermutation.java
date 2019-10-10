package pers;

import java.util.Stack;

/**
 * 60. 第k个排列
 * https://leetcode-cn.com/problems/permutation-sequence/submissions/
 *
 * 其他解法 ： 逆康托展开
 */
public class GetPermutation {
    
    /**
     * 全排列 + 剪枝
     */
    public String getPermutation(int n, int k) {
    
        Stack<Integer> stack = new Stack<>();
        boolean[] used = new boolean[n + 1];

        backtrack(n, k, 0, used, stack);

        StringBuilder strBuil = new StringBuilder();
        stack.forEach(strBuil::append);
        
        return strBuil.toString();
    }
    
    private int backtrack(int n, int k, int count, boolean[] used, Stack<Integer> stack) {
    
        if (k == count) {
            return count;
        }
        
        if (stack.size() == n) {
            return count + 1;
        }
        
        for (int i = 1; i <= n; i++) {
        
            if (used[i]) {
                continue;
            }
        
            stack.push(i);
            used[i] = true;
            count = backtrack(n, k, count, used, stack);
            if (k == count) {
                return count;
            }
            
            stack.pop();
            used[i] = false;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        GetPermutation obj = new GetPermutation();
        System.out.println(obj.getPermutation(3, 3));
        System.out.println(obj.getPermutation(4, 9));
        System.out.println(obj.getPermutation(1, 1));
    }
    
}
