package pers.doublePoint;

/**
 * 287. 寻找重复数
 * https://leetcode.cn/problems/find-the-duplicate-number/description/
 * @auther ken.ck
 * @date 2023/11/5 21:51
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {

        // 把数组当成链表
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            // 出现循环
            if (slow == fast) {
                slow = 0;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }

    public static void main(String[] args) {
        FindDuplicate obj = new FindDuplicate();
        System.out.println(obj.findDuplicate(new int[]{1,2,3,4,5,2}));
    }

}
