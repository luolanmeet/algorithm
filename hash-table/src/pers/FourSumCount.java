package pers;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * https://leetcode-cn.com/problems/4sum-ii/
 * @author cck
 */
public class FourSumCount {
        
    /**
     * 先做两两相加，结果存入到Map中
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        
        int len = A.length;
        
        Map<Integer, Integer> map = new HashMap<>(len * len);
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Integer temp = A[i] + B[j];
                Integer count = map.getOrDefault(temp, 0);
                map.put(temp, count + 1); 
            }
        }
        
        int res = 0;
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                
                Integer temp = C[i] + D[j];
                res += map.getOrDefault(-temp, 0);
            }
        }

        return res;
    }
    
    public static void main(String[] args) {
        
        FourSumCount obj = new FourSumCount();
        
        int res = obj.fourSumCount(
                new int[]{ 1, 2}, 
                new int[]{-2,-1},
                new int[]{-1, 2},
                new int[]{ 0, 2});
        System.out.println(res);
    }
    
}
