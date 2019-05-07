package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 870. 优势洗牌
 * https://leetcode-cn.com/problems/advantage-shuffle/submissions/
 * @author cck
 */
public class AdvantageCount {
    
    public int[] advantageCount(int[] A, int[] B) {

        Arrays.sort(A);
        
        // 存储B中数据的位置
        Map<Integer, List<Integer>> map = new HashMap<>(B.length);
        for (int i = 0; i < B.length; i++) {
            List<Integer> list = map.get(B[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(B[i], list);
            }
            list.add(i);
        }
        Arrays.sort(B);
        
        int[] res = new int[A.length];
        
        int l = 0;
        int r = B.length - 1;

        // 如果A的最小比B的最小小，则A的最小对B的最大
        // 如果A的最小比B的最小小，则A的最小对B的最小
        for (int i = 0; i < A.length; i++) {
            
            int val = 0;
            
            if (A[i] > B[l]) {
                val = B[l++];
            } else {
                val = B[r--];
            }
            
            List<Integer> list = map.get(val);
            Integer index = list.remove(0);
            res[index] = A[i];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
            
        AdvantageCount obj = new AdvantageCount();
        System.out.println(Arrays.toString(obj.advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11})));
        System.out.println(Arrays.toString(obj.advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11})));
    }
    
}
