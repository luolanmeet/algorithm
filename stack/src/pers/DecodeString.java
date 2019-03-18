package pers;

import java.util.Stack;

/**
 * 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 * @author cck
 */
public class DecodeString {
    
    public String decodeString(String s) {
        
        Stack<String> strs = new Stack<>();
        Stack<Integer> ns = new Stack<>();
        
        char[] cs = s.toCharArray();
        
        for (int i = 0; i < cs.length; ) {
            
            // 数字
            if (Character.isDigit(cs[i])) {
                
                int val = 0;
                while (Character.isDigit(cs[i])) {
                    val = val * 10 + cs[i++] - 48; 
                }
                ns.push(val);
                continue;
            }
            
            // 左边，这个要保留，用于确定栈中哪些字符串是一体的   2[2[a]3[b]] --> 2[aabbb]
            if ('[' == cs[i]) {
                strs.push("[");
                i++;
                continue;
            }
            
            // 右边，此时可以确定一个字符串了
            if (']' == cs[i]) {
                i++;
                
                String str = "";
                while (!strs.isEmpty() && !strs.peek().equals("[")) {
                    str = strs.pop() + str;
                }
                // 移除 [ 
                strs.pop();
                
                Integer count = ns.pop();
                
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    temp.append(str);
                }
                strs.push(temp.toString());
                
                continue;
            }
            
            // 字母
            StringBuilder temp = new StringBuilder();
            while (i < cs.length && Character.isLetter(cs[i])) {
                temp.append(cs[i++]);
            }
            
            strs.push(temp.toString());
        }
        
        String resp = "";
        
        while (!strs.isEmpty()) {
            resp = strs.pop() + resp;
        }
        
        return resp;
    }

    public static void main(String[] args) {
        
        DecodeString obj = new DecodeString();
        System.out.println(obj.decodeString("3[a]2[bc]")); //aaabcbc
        System.out.println(obj.decodeString("3[a2[c]]")); //accaccacc
        System.out.println(obj.decodeString("2[abc]3[cd]ef")); //abcabccdcdcdef
        System.out.println(obj.decodeString("abcdefg"));
    }
    
}
