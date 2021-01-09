package pers.doublePoint.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author cck
 * @date 2021/1/9 10:56
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> exist = new HashSet<>();

        int left = 0, right = 0, maxLen = 0;
        while (right < s.length()) {

            char c = s.charAt(right);
            right++;

            // 窗口左边界不需要右移
            if (!exist.contains(c)) {
                exist.add(c);
                continue;
            }

            maxLen = Math.max(exist.size(), maxLen);

            // 缩小窗口，一直到把原来add进入的c移除掉为止
            while (exist.contains(c)) {
                char d = s.charAt(left);
                left++;
                exist.remove(d);
            }
            exist.add(c);
        }

        return Math.max(exist.size(), maxLen);
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstring(""));
    }

}
