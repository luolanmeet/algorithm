package pers;

/**
 * 791. 自定义字符串排序
 * https://leetcode.cn/problems/custom-sort-string/
 *
 * 给定两个字符串 order 和 s 。order 的所有字母都是 唯一 的，并且以前按照一些自定义的顺序排序。
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
 * 返回 满足这个性质的 s 的任意一种排列 。
 *
 * 示例 1:
 * 输入: order = "cba", s = "abcd"
 * 输出: "cbad"
 * 解释:
 * “a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
 * 因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。
 *
 * 提示:
 * 1 <= order.length <= 26
 * 1 <= s.length <= 200
 * order 和 s 由小写英文字母组成
 * order 中的所有字符都 不同
 *
 * @auther ken.ck
 * @date 2022/11/14 21:07
 */
public class CustomSortString {

    public String customSortString(String order, String s) {

        // 记录原字符串中字符串的个数，然后造一个符合要求的字符串返回
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder resp = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (count[c - 'a'] > 0) {
                resp.append(c);
                count[c - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                resp.append((char)('a' + i));
                count[i]--;
            }
        }

        return resp.toString();
    }

    public static void main(String[] args) {
        CustomSortString obj = new CustomSortString();
        System.out.println(obj.customSortString("cbafg", "abcd"));
    }

}
