package pers.doublePoint.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串 https://leetcode-cn.com/problems/minimum-window-substring/
 * 滑动窗口
 * @author cck
 * @date 2021/1/8 21:04
 */
public class MinWindow {

    public String minWindow(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 存储需要的字符
        for (char c : t.toCharArray())
            need.merge(c, 1, Integer::sum);

        // valid用来表示窗口中满足need条件的字符的个数，当valid和s.length相同时，代表覆盖了串s
        int left = 0, right = 0, valid = 0;

        // 记录最小覆盖子串的起始索引和长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {

            // c是将移入窗口的字符
            char c = s.charAt(right);

            // 右移窗口
            right++;

            // 在窗口内进行一些列更新
            if (need.containsKey(c)) {
                window.merge(c, 1, Integer::sum);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // d是将移除窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.merge(d, -1, Integer::sum);
                }
            }
        }

        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {

        MinWindow obj = new MinWindow();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(obj.minWindow("aa", "aa"));
    }

}
