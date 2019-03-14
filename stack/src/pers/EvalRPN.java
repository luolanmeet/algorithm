package pers;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @author cck
 */
public class EvalRPN {
    
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        
        // 栈顶元素在运算符右边
        int temp;
        
        for (String token : tokens) {
            
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
                continue;
            }
            
            if ("-".equals(token)) {
                temp = stack.pop();
                stack.push(stack.pop() - temp);
                continue;
            }
            
            if ("/".equals(token)) {
                temp = stack.pop();
                stack.push(stack.pop() / temp);
                continue;
            }
            
            if ("*".equals(token)) {
                temp = stack.pop();
                stack.push(stack.pop() * temp);
                continue;
            }
            
            stack.push(Integer.valueOf(token));
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args) {
        
        EvalRPN obj = new EvalRPN();
        System.out.println(obj.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(obj.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
    
}
