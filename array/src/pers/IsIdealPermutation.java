package pers;

/**
 * 775. 全局倒置与局部倒置
 * https://leetcode.cn/problems/global-and-local-inversions/description/
 *
 * 给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
 * 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目：
 * 0 <= i < j < n
 * nums[i] > nums[j]
 * 局部倒置 的数目等于满足下述条件的下标 i 的数目：
 *
 * 0 <= i < n - 1
 * nums[i] > nums[i + 1]
 * 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。
 *
 *
 * 示例 1：
 * 输入：nums = [1,0,2]
 * 输出：true
 * 解释：有 1 个全局倒置，和 1 个局部倒置。
 *
 * @auther ken.ck
 * @date 2022/11/16 11:58
 */
public class IsIdealPermutation {

    public boolean isIdealPermutation(int[] nums) {

        // 全局倒置 肯定 包含了 局部倒置
        // 要判断是否 全局和局部 的数量相同，只需看是否存在一个即可
        // nums[i] > nums[j], j > i + 1

        int n = nums.length;
        int min = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > min) {
                return false;
            }
            min = Math.min(min, nums[i + 1]);
        }

        return true;
    }

    public boolean isIdealPermutation2(int[] nums) {
        // 暴力
        int a = 0;
        int b = 0;
        for (int step = 1; step < nums.length; step++) {
            int tmp = 0;
            for (int i = 0; i + step < nums.length; i++) {
                if (nums[i] > nums[i + step]) {
                    tmp++;
                }
            }
            a += tmp;
            if (step == 1) {
                b = tmp;
            }
        }
        return a == b;
    }

    public static void main(String[] args) {
        IsIdealPermutation obj = new IsIdealPermutation();
        System.out.println(obj.isIdealPermutation(new int[]{0,2,3,1}));
    }

}