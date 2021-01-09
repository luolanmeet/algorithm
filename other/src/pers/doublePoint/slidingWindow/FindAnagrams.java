package pers.doublePoint.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @author cck
 * @date 2021/1/9 10:33
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray())
            need.merge(c, 1, Integer::sum);

        int left = 0, right = 0, vaild = 0;
        List<Integer> result = new ArrayList<>();
        while (right < s.length()) {

            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.merge(c, 1, Integer::sum);
                if (need.get(c).equals(window.get(c))) {
                    vaild++;
                }
            }

            while (right - left >= t.length()) {

                if (vaild == need.size()) {
                    result.add(left);
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        vaild--;
                    }
                    window.merge(d, -1, Integer::sum);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAnagrams obj = new FindAnagrams();
        System.out.println(obj.findAnagrams("cbaebabacd", "abc"));
        System.out.println(obj.findAnagrams("abab", "ab"));
    }

}
