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
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        
        for (int num : nums) {
            map.merge(num, 1, (o, n) -> o + n);
        }
        
        // 桶，一开始用了一个 Map<Integer,List<Integer>> 的结构，后边改掉了
        List[] ls = new List[nums.length + 1]; 
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            
            if (ls[entry.getValue()] == null) {
                ls[entry.getValue()] = new ArrayList<>();
            }
            
            ls[entry.getValue()].add(entry.getKey());
        }

        List<Integer> res = new ArrayList<>(k);

        for (int i = ls.length - 1; i > 0 && res.size() < k; i--) {
            
            if (ls[i] != null) {
                res.addAll(ls[i]);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        TopKFrequent obj = new TopKFrequent();
        System.out.println(obj.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(obj.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2));
    }
    
}
