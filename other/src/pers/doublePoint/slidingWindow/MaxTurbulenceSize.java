package pers.doublePoint.slidingWindow;

/**
 * 978. 最长湍流子数组
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/
 * @author cck
 * @date 2021/6/14 16:37
 */
public class MaxTurbulenceSize {

    public int maxTurbulenceSize(int[] arr) {

        // 注意要处理两数相等的情况

        int n = arr.length;
        int res = 1;
        int left = 0, right = 0;

        while (right < n - 1) {

            // 处理两数相等的情况
            if (left == right) {
                if (arr[left] == arr[left+1]) {
                    left++;
                }
                right++;
                res = Math.max(right - left + 1, res);
                continue;
            }

            // 这里无法出现越界的情况
            if (arr[right-1] < arr[right] && arr[right] > arr[right+1]) {
                right++;
            } else if (arr[right-1] > arr[right] && arr[right] < arr[right+1]) {
                right++;
            } else {
                left = right;
            }
            res = Math.max(right - left + 1, res);
        }

        return res;
    }

    public static void main(String[] args) {
        MaxTurbulenceSize obj = new MaxTurbulenceSize();
        System.out.println(obj.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
    }

}
