package pers.doublePoint.slidingWindow;

/**
 * 1456. 定长子串中元音的最大数目
 * https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
public class MaxVowels {

    public int maxVowels(String s, int k) {
        int n = s.length();
        int vowel_count = 0;
        for (int i = 0; i < k; i++) {
            vowel_count += isVowel(s.charAt(i));
        }
        int ans = vowel_count;
        for (int i = k; i < n; i++) {
            vowel_count += isVowel(s.charAt(i)) - isVowel(s.charAt(i - k));
            ans = Math.max(ans, vowel_count);
        }
        return ans;
    }

    public int isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
    }

    public int maxVowels2(String s, int k) {

        int res = 0;

        int l = 0, r = 0;
        int tmp = 0;

        while (r < s.length()) {

            if (isVowel2(s.charAt(r))) {
                tmp++;
            }
            res = Math.max(res, tmp);

            // 收缩窗口
            if (r - l + 1 == k) {
                if (isVowel2(s.charAt(l))) {
                    tmp--;
                }
                l++;
                while (l < r) {
                    if (isVowel2(s.charAt(l))) {
                        break;
                    }
                    l++;
                }
            }
            r++;
        }

        return res;
    }

    public boolean isVowel2(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        MaxVowels obj = new MaxVowels();
        System.out.println(obj.maxVowels("abciiidef", 3));
        System.out.println(obj.maxVowels("aeiou", 2));
    }

}
