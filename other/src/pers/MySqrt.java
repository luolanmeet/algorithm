package pers;

/**
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class MySqrt {

    // 牛顿迭代法
    public int mySqrt(int x) {

        long l = x;
        
        while (l * l > x) {
            l = (l + x / l) / 2;
        }
        
        return (int) l;
    }

    // 用二分法
    public int mySqrt2(int x) {

        if (x <= 0) {
            return 0;
        }

        int left = 1;
        int right = x;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int result = x / mid;

            if (result == mid) {
                return mid;
            }

            if (result < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
    
    public static void main(String[] args) {
        
        MySqrt obj = new MySqrt();
        System.out.println(obj.mySqrt(3));
        System.out.println(obj.mySqrt2(3));
        
        System.out.println(obj.mySqrt(14));
        System.out.println(obj.mySqrt2(14));
    }
    
}
