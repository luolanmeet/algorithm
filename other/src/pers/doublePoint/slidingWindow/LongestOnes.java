package pers.doublePoint.slidingWindow;

/**
 * 1004. 最大连续1的个数 III
 * https://leetcode.cn/problems/max-consecutive-ones-iii/
 * @auther ken.ck
 * @date 2023/8/13 14:42
 */
public class LongestOnes {

    public int longestOnes(int[] nums, int k) {

        int l = 0;
        int r = 0;
        int res = 0;
        while (r < nums.length) {
            if (nums[r] == 1) {
                r++;
                res = Math.max(res, r - l);
                continue;
            }
            // 有次数可以翻转
            if (k > 0) {
                r++;
                res = Math.max(res, r - l);
                k--;
                continue;
            }
            // 当前值为0，且没次数翻转
            // 找到最前边翻转的地方，把次数让出来
            while (nums[l] == 1) {
                l++;
            }
            // 最前边翻转的地方
            // 如果k的初始值是0的情况，这时 l 会跑到 r 前边，后续的结果也是正确的。。
            l++;
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestOnes obj = new LongestOnes();
        System.out.println(obj.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(obj.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        System.out.println(obj.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 0));
        System.out.println(obj.longestOnes(new int[]{0,0,0,1}, 1));
    }

}
