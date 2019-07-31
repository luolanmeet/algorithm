package pers.sword;
/**
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *   1 2  8  9
 *   2 4  9 12
 *   4 7 10 13
 *   6 8 11 15
 *   从右上方开始查找，如果等于，则返回
 *   如果目标值大于当前值，则剔除当前行
 *   如果目标值小于当前值，则剔除当前列
 * @author cck
 */
public class Algorithm3 {

    public boolean isExist(int[][] nums, int target) {
        
        int rLen = nums[0].length - 1;
        
        for (int i = 0; i < nums.length && rLen >= 0; ) {
            
            if (nums[i][rLen] == target) {
                return true;
            }
    
            if (nums[i][rLen] > target) {
                rLen--; // 剔除列
            } else {
                i++; // 剔除行
            }
            
        }
        return false;
    }
    
    public static void main(String[] args) {
        Algorithm3 obj = new Algorithm3();
        int[][] nums = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(obj.isExist(nums, 4));
    }
    
}
