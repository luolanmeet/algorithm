package pers;

import java.util.HashSet;
import java.util.Set;

/**
 * 2516. 每种字符至少取 K 个
 * https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/description/
 * @auther ken.ck
 * @date 2024/9/27 19:59
 */
public class TakeCharacters {

    Set<String> set = new HashSet<>();
    int res = 0;
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        res = Integer.MAX_VALUE;
        set = new HashSet<>();
        backTrack(s, 0, s.length() - 1, count, 0, k);
        return res == Integer.MAX_VALUE ? -1 : res ;
    }

    public void backTrack(String s, int left, int right, int[] count, int time, int k) {

        // 超时了。回溯本质上就是暴力，只是加上一些剪枝可以进行优化

        if (count[0] >= k && count[1] >= k && count[2] >= k) {
            res = Math.min(res, time);
            return ;
        }
        if (left > right || time >= res) {
            return ;
        }
        if (set.contains(left + " " + right)) {
            return;
        }
        set.add(left + "" + right);

        time++;

        // 尝试取走左边
        count[s.charAt(left) - 'a']++;
        backTrack(s, left + 1, right, count, time, k);
        count[s.charAt(left) - 'a']--; // 还原

        // 尝试取走右边
        count[s.charAt(right) - 'a']++;
        backTrack(s, left, right - 1, count, time, k);
        count[s.charAt(right) - 'a']--; // 注意这里也要还原
    }

    public static void main(String[] args) {
        TakeCharacters obj = new TakeCharacters();
        System.out.println(obj.takeCharacters("aabaaaacaabc", 2));
    }

}
