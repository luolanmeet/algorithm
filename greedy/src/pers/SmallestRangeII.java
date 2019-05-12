package pers;

import java.util.Arrays;

/**
 * 910. 最小差值 II
 * https://leetcode-cn.com/problems/smallest-range-ii/comments/
 * @author cck
 */
public class SmallestRangeII {
    
    // 没做出来，这个网上大佬的解法
    public int smallestRangeII(int[] A, int K) {
        
        // 对 A 进行排序，若整个数组同加同减那么差值就是 A[-1]-A[0] 。
        // 半加半减情况则可将 A 视为俩部分 A1<A2，为了使差值最小，只能 A1 同加， A2 同减。
        // 那么整个 A 的最大值只能是 A1 尾或 A2 尾，最小值只能是 A1 头或 A2 头，比较这4个值就可以求得差值。
        
        Arrays.sort(A);
        int n = A.length;
        int res = A[n-1] - A[0];
        for (int i=1;i<n;i++) {
          int min = Math.min(A[0]+K,A[i]-K);
          int max = Math.max(A[n-1]-K,A[i-1]+K);
          res = Math.min(max-min,res);
        }
        return res;
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        
        SmallestRangeII obj = new SmallestRangeII();
        System.out.println(obj.smallestRangeII(new int[]{1,3,6}, 3));
        System.out.println(obj.smallestRangeII(new int[]{7,8,8}, 3));
        System.out.println(obj.smallestRangeII(new int[]{5,9,9,10}, 5));
        System.out.println(obj.smallestRangeII(new int[]{2,2,4,7,8}, 5));
    }
    
}
