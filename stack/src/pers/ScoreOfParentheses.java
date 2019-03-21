package pers;

import java.util.Stack;

/**
 * 856. 括号的分数
 * https://leetcode-cn.com/problems/score-of-parentheses/
 * @author cck
 */
public class ScoreOfParentheses {
    
    public int scoreOfParentheses(String S) {
        
        char[] cs = S.toCharArray();
        
        Stack<String> stack = new Stack<>();
        
        int i = 0;
        while (i < cs.length) {
            
            if (cs[i] == '(') {
                stack.push("(");
                i++;
                continue;
            }
            
            int val = 0;
            
            // 栈顶为"(", 和 cs[i] 组成 "()"，则值为1
            if (stack.peek().equals("(")) {
                val = 1;
            } else {
                // 和 cs[i] 组成"(数字)"，则将数字翻倍
                val = Integer.valueOf(stack.pop());
                val *= 2;
            }
            
            //　将"("弹出
            stack.pop();
            
            //　和之前的数字合并
            while (!stack.isEmpty() 
                    && !stack.peek().equals("(")  
                    && !stack.peek().equals(")")) {
                
                val += Integer.valueOf(stack.pop());
            }
            stack.push(val + "");
            i++;
        }
        
        return Integer.valueOf(stack.pop());
    }
    
    public static void main(String[] args) {
        
        ScoreOfParentheses obj = new ScoreOfParentheses();
        System.out.println(obj.scoreOfParentheses("()"));
        System.out.println(obj.scoreOfParentheses("(())"));
        System.out.println(obj.scoreOfParentheses("()()"));
        System.out.println(obj.scoreOfParentheses("(()(()))"));
    }
    
}
