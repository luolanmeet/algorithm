package pers;

import java.util.*;

/**
 *  3. 无重复字符的最长子串
 *  https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/comments/
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    
    public int lengthOfLongestSubstring(String s) {
        
        // 用于判断重复
        Set<Character> set = new HashSet<>(s.length());
        // 维护当前不重复的字符
        List<Character> list = new ArrayList<>(s.length());
        char[] cs = s.toCharArray();
        int max = 0;
        
        for (int i = 0; i < cs.length; i++) {
            
            // 遇到重复
            if (set.contains(cs[i])) {
                
                max = Math.max(max, list.size());
                
                Iterator<Character> iterator = list.iterator();
                // 去除 字符串开始到重复的字符 这段字符串
                while (iterator.hasNext()) {
                    Character c = iterator.next();
                    iterator.remove();
                    set.remove(c);
                    if (c == cs[i]) {
                        break;
                    }
                }
            }
            
            set.add(cs[i]);
            list.add(cs[i]);
        }
        
        max = Math.max(max, list.size());
        
        return max;
    }
    
    public static void main(String[] args) {
    
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        System.out.println(obj.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    }
    
}
