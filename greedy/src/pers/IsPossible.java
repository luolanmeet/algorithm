package pers;

import java.util.HashMap;
import java.util.Map;

/**
 * 659. 分割数组为连续子序列
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 * @author cck
 */
public class IsPossible {

    public boolean isPossible(int[] nums) {
        
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            
            Integer count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }
        
        for (int num : nums) {
            
            if (countMap.get(num) == 0) {
                continue;
            }
            
            countMap.put(num, countMap.get(num) - 1);
            
            if (map.containsKey(num - 1) && map.get(num - 1) > 0) {
                        
                Integer count = map.get(num - 1);
                map.put(num - 1, count - 1);
                count = map.getOrDefault(num, 0);
                map.put(num, count + 1);
                continue;
            }
            
            if (countMap.containsKey(num + 1) && countMap.get(num + 1) > 0
                    && countMap.containsKey(num + 2) && countMap.get(num + 2) > 0) {
                
                Integer count = map.getOrDefault(num + 2, 0);
                map.put(num + 2, count + 1);
                
                countMap.put(num + 1, countMap.get(num + 1) - 1);
                countMap.put(num + 2, countMap.get(num + 2) - 1);
                continue;
            }
            
            return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
        IsPossible obj = new IsPossible();
        System.out.println(obj.isPossible(new int[] {1,2,3,3,4,5})); // 123 345
        System.out.println(obj.isPossible(new int[] {1,2,3,3,4,4,5,5})); // 12345 345
        System.out.println(obj.isPossible(new int[] {1,2,3,4,4,5}));
    }
    
}
