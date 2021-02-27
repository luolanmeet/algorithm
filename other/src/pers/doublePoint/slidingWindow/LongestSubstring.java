package pers.doublePoint.slidingWindow;

/**
 * 395. 至少有K个重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * @author cck
 * @date 2021/2/27 8:42
 */
public class LongestSubstring {

    public int longestSubstring(String s, int k) {

        // 用滑动窗口算法的难点在于
        // 如何判断需要缩小窗口，cs[left]字母可能在后边会有用，没法草率做窗口缩小
        // 如果题目是 q个元素，每个元素出现个数不少于k 的字符串，
        // 那么缩小窗口的判断就可以是，出现新元素，且当前元素个数已经等于q的时候，做窗口移动。
        // 由于有26个字母，所以外层是26的循环，里边是窗口算法
        /**
             for (int i = 0; i < 26; i++) {
                // 窗口算法
                while (right < len) {
                    // 右窗口右移
                    // 左窗口右移
                }
             }
             // 计算最大值返回
         */

        int res = 0;
        char[] cs = s.toCharArray();

        // 限制出现的字母的个数  ab -> 2  aaa -> 1
        for (int i = 1; i <= 26; i++) {

            int[] count = new int[26];
            int l = 0, r = 0;
            // 出现的字母个数
            int totalElement = 0;
            // 数量凑够k个的字母个数
            int finsh = 0;
            while (r < cs.length) {

                count[cs[r] - 'a']++;

                // 字母是第一次出现
                if (count[cs[r] - 'a'] == 1) {
                    totalElement++;
                }
                // 字母满足要求
                if (count[cs[r] - 'a'] == k) {
                    finsh++;
                }

                // 左窗口右移
                while (totalElement > i) {
                    // 原理是刚好满足的
                    if (count[cs[l] - 'a'] == k) {
                        finsh--;
                    }
                    count[cs[l] - 'a']--;
                    // 成功移除掉一个字母
                    if (count[cs[l] - 'a'] == 0) {
                        totalElement--;
                    }
                    l++;
                }

                if (finsh == i) {
                    res = Math.max(r - l + 1, res);
                }

                r++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstring obj = new LongestSubstring();
        System.out.println(obj.longestSubstring("aaabb", 3));
        System.out.println(obj.longestSubstring("ababbc", 2));
    }

}
