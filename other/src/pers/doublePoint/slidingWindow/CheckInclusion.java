package pers.doublePoint.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 * @author cck
 * @date 2021/1/9 9:15
 */
public class CheckInclusion {

    public boolean checkInclusion2(String t, String s) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray())
            need.merge(c, 1, Integer::sum);

        // vaild
        int left = 0, right = 0, vaild = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            // 窗口右边界向右移动
            right++;

            if (need.containsKey(c)) {
                window.merge(c, 1, Integer::sum);
                if (need.get(c).equals(window.get(c))) {
                    vaild++;
                }
            }

            // 判断窗口是否要收缩
            // 注意 >= ，进入下一轮循环时，窗口中的字符长度一定是小于目标字符串长度
            while (right - left >= t.length()) {

                if (vaild == need.size()) {
                    return true;
                }

                char d = s.charAt(left);
                // 窗口左边界向右移动
                left++;

                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        vaild--;
                    }
                    window.merge(d, -1, Integer::sum);
                }
            }
        }

        return false;
    }

    public boolean checkInclusion(String t, String s) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray())
            need.merge(c, 1, Integer::sum);

        // len保存当前窗口中的字符串长度
        int left = 0, right = 0, len = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            // 窗口右边界向右移动
            right++;

            // 字符不在目标字符串中，直接跳过，从头开始
            if (!need.containsKey(c)) {
                len = 0;
                window.clear();
                left = right;
                continue;
            }

            window.merge(c, 1, Integer::sum);
            len++;

            // 判断窗口是否要收缩
            while (len > t.length()) {
                char d = s.charAt(left);
                // 窗口左边界向右移动
                left++;
                window.merge(d, -1, Integer::sum);
                len--;
            }

            if (len == t.length()) {
                boolean isFind = true;
                for (Map.Entry<Character, Integer> entry : need.entrySet()) {
                    if (!entry.getValue().equals(window.get(entry.getKey()))) {
                        isFind = false;
                        break;
                    }
                }
                if (isFind) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion obj = new CheckInclusion();
        System.out.println(obj.checkInclusion("ab", "eidbaooo"));
        System.out.println(obj.checkInclusion("ab", "eidboaoo"));
        System.out.println(obj.checkInclusion("adc", "dcda"));
        System.out.println();
        System.out.println(obj.checkInclusion2("ab", "eidbaooo"));
        System.out.println(obj.checkInclusion2("ab", "eidboaoo"));
        System.out.println(obj.checkInclusion2("adc", "dcda"));
    }

}
