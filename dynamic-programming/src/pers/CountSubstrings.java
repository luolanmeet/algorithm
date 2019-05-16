package pers;

/**
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/submissions/
 * @author cck
 */
public class CountSubstrings {

    public int countSubstrings(String s) {
        
        // 如果  cs[i] == cs[j], 并且  【i+1，j-1】 也是回文字符串，
        // 那么【i,j】也是回文字符串 
        
        char[] cs = s.toCharArray();
        int len = s.length();
        boolean[][] dpB = new boolean[len][len];
        
        int res = len;
        // 自身比较
        for (int i = 0; i < s.length(); i++) {
            dpB[i][i] = true;
        }
        
        // 相邻的字符比较  dpB[i+1][i+size-1] 不适用与 相邻的字符比较，因此单独拿出
        for (int i = 0; i < len - 1; i++) {
            if (cs[i] == cs[i + 1]) {
                res++;
                dpB[i][i + 1] = true;
            }
        }
        
        // 多个字符串比较
        for (int size = 2; size < len; size++) {
            
            for (int i = 0; i < len - size; i++) {
                
                if (cs[i] == cs[i + size] && dpB[i + 1][i + size - 1]) {
                    res++;
                    dpB[i][i + size] = true;
                }
            }
        }
        
        return res;
    }
    
    int num = 0;
    public int countSubstrings2(String s) {
        
        // 从某个字符串开始，往左右扩散寻找回文字符串
        
        num = 0;
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);     // 回文串长度为奇数
            count(s, i, i + 1); // 回文串长度为偶数
        }
        return num;
    }

    public void count(String s, int start, int end) {
        
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num++;
            start--;
            end++;
        }
    }
    
    public static void main(String[] args) {
        
        CountSubstrings obj = new CountSubstrings();
        System.out.println(obj.countSubstrings2("abc")); // 3
        System.out.println(obj.countSubstrings2("aaa")); // 6
        System.out.println(obj.countSubstrings2("aaaa")); // 10
        System.out.println(obj.countSubstrings2("longtimenosee")); // 14
    }
    
}
