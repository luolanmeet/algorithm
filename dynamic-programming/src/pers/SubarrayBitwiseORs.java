package pers;

import java.util.HashSet;
import java.util.Set;

/**
 * 898. 子数组按位或操作
 * https://leetcode-cn.com/problems/bitwise-ors-of-subarrays/
 * @author cck
 */
public class SubarrayBitwiseORs {
    
    // 神马动态规划。。
    // 看其他人的解法，好像都是要o(n^2)
    public int subarrayBitwiseORs(int[] A) {
        
        Set<Integer> ored = new HashSet<>(A.length);
        Set<Integer> res  = new HashSet<>(A.length);
        
        int len = A.length;
        int max = 0;
        
        for (int i = 0; i < len; i++) {
            max |= A[i];
        }
        
        for (int i = 0; i < A.length; i++) {
            
            if (ored.contains(A[i])) {
                continue;
            }
            
            res.add(A[i]);
            int temp = A[i];
            
            for (int j = i + 1; j < A.length && temp < max; j++) {
                temp |= A[j];
                res.add(temp);
            }
        }
        
        return res.size();
    }
    
    public static void main(String[] args) {
        SubarrayBitwiseORs obj = new SubarrayBitwiseORs();
        System.out.println(obj.subarrayBitwiseORs(new int[]{0}));
        System.out.println(obj.subarrayBitwiseORs(new int[]{1,1,2}));
    }
    
}
