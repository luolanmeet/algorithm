package pers;

/**
 * 10. 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class IsMatch {
    
    public boolean isMatch(String s, String p) {
        
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        
        // 第一个字符是否相等
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        
        // p 是以 ?* 开始的
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 0个? 和 >0个? 的情况
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            // 不以 ?* 开始的情况
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
    
    public static void main(String[] args) {
        IsMatch obj = new IsMatch();
        System.out.println(obj.isMatch("aa", "a*"));
    }
    
}
