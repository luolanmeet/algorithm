package pers;

/**
 * 334. 递增的三元子序列
 * https://leetcode.cn/problems/increasing-triplet-subsequence/
 */
public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > second) {
                return true;
            }
            if (nums[i] > first) {
                second = nums[i];
            } else {
                first = nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplet obj = new IncreasingTriplet();
        System.out.println(obj.increasingTriplet(new int[] {5,4,3,2,1}));
        System.out.println(obj.increasingTriplet(new int[] {1,2,3,4,5}));
    }

}
