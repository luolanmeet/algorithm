package pers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. 前K个高频元素 (nums = [1,2,1,2] k = 1 要返回什么)
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @author cck
 */
public class TopKFrequent {
    
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        
        for (int num : nums) {
            map.merge(num, 1, (o, n) -> o + n);
        }
        
        Map<Integer, List<Integer>> map2 = new HashMap<>(map.size());
        
        Integer max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
            
            List<Integer> temp = map2.get(entry.getValue());
            if (temp == null) {
                temp = new ArrayList<>();
                map2.put(entry.getValue(), temp);
            }
            temp.add(entry.getKey());
        }
        
        List<Integer> res = new ArrayList<>(k);

        for (int i = 0; i < k; ) {
            
            List<Integer> temp = map2.get(max);
            
            if (temp == null) {
                max--;
                continue;
            }
            
            res.addAll(temp);
            i += temp.size();
            max--;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        TopKFrequent obj = new TopKFrequent();
        System.out.println(obj.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(obj.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2));
    }
    
}
