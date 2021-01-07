package pers.binarySearch;

/**
 * 思考 < <=  +1  right = nums.length -1 这些细节
 * @author cck
 * @date 2021/1/7 22:38
 */
public class BinarySearch {

    /**
     *  最普通的二分查找
     */
    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

    /**
     * 寻找左侧边界的二分查找
     * 即最左边的target的坐标
     */
    int binarySearchLeft(int[] nums, int target) {

        if (nums.length == 0)
            return -1;

        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                right = mid;
            else if (nums[mid] > target)
                right = mid; // 注意
            else if (nums[mid] < target)
                left = mid + 1; // 注意
        }

        return left;
    }

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        System.out.println(obj.binarySearch(new int[]{1,3,3,3,3,3,4}, 3));
        System.out.println(obj.binarySearchLeft(new int[]{1,3,3,3,3,3,4}, 3));
    }

 }
