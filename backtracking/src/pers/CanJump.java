package pers;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        // 超时了
        return method(nums, 0);
    }

    private boolean method(int[] nums, int idx) {

        if (idx >= nums.length - 1) {
            return true;
        }

        if (nums[idx] == 0) {
            return false;
        }

        if (idx + nums[idx] >= nums.length - 1) {
            return true;
        }

        for (int i = nums[idx]; i > 0; i--) {

            if (method(nums, idx + i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump obj = new CanJump();
        System.out.println(obj.canJump(new int[]{2,3,1,1,4}));
    }

}
