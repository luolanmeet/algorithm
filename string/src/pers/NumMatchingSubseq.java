package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * 792. 匹配子序列的单词数
 * https://leetcode.cn/problems/number-of-matching-subsequences/description/
 *
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * 例如， “ace” 是 “abcde” 的子序列。
 *
 * 示例 1:
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"
 *
 * 提示:
 *
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成。
 *
 * @auther ken.ck
 * @date 2022/11/17 10:00
 */
public class NumMatchingSubseq {

    public int numMatchingSubseq(String s, String[] words) {

        List<Integer>[] idxs = new List[26];
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (idxs[c - 'a'] == null) {
                idxs[c - 'a'] = new ArrayList<>();
            }
            idxs[c - 'a'].add(idx++);
        }

        int res = 0;
        for (String word : words) {

            idx = -1;
            boolean match = true;
            for (char c : word.toCharArray()) {
                if (idxs[c - 'a'] == null || idxs[c - 'a'].get(idxs[c - 'a'].size() - 1) <= idx) {
                    match = false;
                    break;
                }
                // 二分查找
                idx = bs(idxs[c - 'a'], idx);
            }

            if (match) {
                res++;
            }
        }

        return res;
    }

    private int bs(List<Integer> idxs, int idx) {
        int left = 0;
        int right = idxs.size() - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (idxs.get(mid) > idx) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return idxs.get(left);
    }

    public static void main(String[] args) {
        NumMatchingSubseq obj = new NumMatchingSubseq();
        System.out.println(obj.numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
    }

}
