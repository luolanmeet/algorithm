package pers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 131. 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * @author cck
 */
public class Partition {
    
    public List<List<String>> partition(String s) {
    
        List<List<String>> res = new ArrayList<>();
        backstrck(res, s, 0, new Stack<String>());
        
        return res;
    }
    
    private void backstrck(List<List<String>> res, String s, int index, Stack<String> stack) {
    
        if (index == s.length()) {
            res.add(new ArrayList<>(stack));
            return ;
        }
        
        // 从 index 开始切割，一直尝试到 s.length()
        for (int i = index + 1; i <= s.length(); i++) {
    
            String tmp = s.substring(index, i);
            
            if (!isPalindrome(tmp)) {
                continue;
            }
            
            stack.push(tmp);
            backstrck(res, s, i, stack);
            stack.pop();
        }
    
    }
    
    public static boolean isPalindrome(String str) {
    
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right)
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        return true;
    }
    
    public static void main(String[] args) {
    
        Partition obj = new Partition();
        System.out.println(obj.partition("aab"));
        System.out.println(obj.partition("aabaa"));
        System.out.println(obj.partition("aabbb"));
    }
    
}
