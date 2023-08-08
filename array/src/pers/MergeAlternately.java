package pers;

/**
 * 1768. 交替合并字符串
 * https://leetcode.cn/problems/merge-strings-alternately/
 */
public class MergeAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                res.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                res.append(word2.charAt(i));
            }
            i++;
        }
        return res.toString();
    }

    public String mergeAlternately2(String word1, String word2) {

        StringBuilder res = new StringBuilder();
        int minLen = Math.min(word1.length(), word2.length());
        for (int i = 0; i < minLen; i++) {
            res.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if (word1.length() > minLen) {
            res.append(word1.substring(minLen));
        }
        if (word2.length() > minLen) {
            res.append(word2.substring(minLen));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        MergeAlternately obj = new MergeAlternately();
        System.out.println(obj.mergeAlternately("abc", "pqr"));
        System.out.println(obj.mergeAlternately("ab", "pqrs"));
    }

}
