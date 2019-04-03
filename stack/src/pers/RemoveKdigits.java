package pers;

import java.util.Stack;

/**
 * 402. 移掉K位数字
 * https://leetcode-cn.com/problems/remove-k-digits/submissions/
 * @author cck
 */
public class RemoveKdigits {
    
    public String removeKdigits(String num, int k) {
        
        if (k >= num.length()) {
            return "0";
        }
        
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < num.length(); i++) {
            
            if (stack.isEmpty()) {
                stack.push(num.charAt(i) + "");
                continue;
            }
            
            Integer tem = Integer.parseInt(num.charAt(i) + "");
            while (k > 0 && !stack.isEmpty() && tem < Integer.parseInt(stack.peek())) {
                
                stack.pop();
                k--;
            }
            
            stack.push(num.charAt(i) + "");
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result; 
        }
        
        while (result.startsWith("0")) {
            result = result.substring(1);
        }
        
        if ("".equals(result)) {
            return "0";
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        
        RemoveKdigits obj = new RemoveKdigits();
        System.out.println(obj.removeKdigits("1234567890", 9));
    }
    
}
