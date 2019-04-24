package pers;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/
 * @author cck
 */
public class LargestSumAfterKNegations {
    
    public int largestSumAfterKNegations(int[] A, int K) {
        
        Arrays.sort(A);
        
        for (int i = 0; i < K; i++) {
            
            A[0] = -A[0];
            
            if (A.length > 1 && A[0] > A[1]) {
                Arrays.sort(A);
            }
        }
        
        int res = 0;
        for (Integer a : A) {
            res += a;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        LargestSumAfterKNegations obj = new LargestSumAfterKNegations();
        System.out.println(obj.largestSumAfterKNegations(new int[]{4,2,3}, 1));
        System.out.println(obj.largestSumAfterKNegations(new int[]{3,-1,0,2}, 3));
        System.out.println(obj.largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2));
        
    }
    
}
