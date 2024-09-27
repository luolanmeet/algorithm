package pers.doublePoint.slidingWindow;

/**
 * 2516. 每种字符至少取 K 个
 * https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/description/
 * @auther ken.ck
 * @date 2024/9/27 20:41
 */
public class TakeCharacters {

    public int takeCharacters(String s, int k) {
        int[] cnt = new int[3];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        if (cnt[0] < k || cnt[1] < k || cnt[2] < k) {
            return -1;
        }

        // 转换成取最长子串
        int l = 0;
        int r = 0;
        int ans = s.length();
        for ( ; r < len; r++) {
            cnt[s.charAt(r) - 'a']--;
            while (l < r && (cnt[0] < k || cnt[1] < k || cnt[2] < k)) {
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            if (cnt[0] >= k && cnt[1] >= k && cnt[2] >= k) {
                ans = Math.min(ans, len - (r - l + 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TakeCharacters obj = new TakeCharacters();
        System.out.println(obj.takeCharacters("aabaaaacaabc", 2));
    }

}
