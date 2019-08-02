package pers.sword;
/**
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * (例如，数组[0,1,2,4,5,6,7]，可能变为[4,5,6,7,0,1,2])。
 *
 * 请找出其中最小的元素
 *
 * 示例 1:
 *    输入: [3,4,5,1,2]
 *    输出: 1
 *
 * 示例 2:
 *    输入: [4,5,6,7,0,1,2]
 *    输出: 0
 *
 * @author cck
 */
public class Algorithm8 {
    
    public int findMin(int[] nums) {
        
        // 二分查找
        int left = 0;
        int right = nums.length - 1;
    
        // 原数组就是有序的，没有旋转
        if (nums[left] <= nums[right]) {
            return nums[left];
        }
        
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return nums[mid + 1];
    }
    
    public static void main(String[] args) {
        Algorithm8 obj = new Algorithm8();
        System.out.println(obj.findMin(new int[]{4,5,6,7,1,2}));
        System.out.println(obj.findMin(new int[]{3,4,5,1,2}));
        System.out.println(obj.findMin(new int[]{3,1,2}));
        System.out.println(obj.findMin(new int[]{1,2}));
        System.out.println(obj.findMin(new int[]{1}));
    }
    
}
