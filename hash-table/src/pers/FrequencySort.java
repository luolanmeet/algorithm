package pers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 451. 根据字符出现频率排序
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/comments/
 * @author cck
 */
public class FrequencySort {

    // 强行用流，有点装
    public String frequencySort(String s) {
        
        if (s == null || s.length() == 0) {
            return s;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        s.chars().forEach(c -> {
            map.merge((char) c, 1, (oldVal, newVal) ->{
                return oldVal + newVal;
            });
        });
        
        StringBuilder res = new StringBuilder();
        
        map.entrySet().stream()
        .sorted((e1, e2) -> -e1.getValue().compareTo(e2.getValue()))
        .forEach(e -> {
            
            IntStream.range(0, e.getValue()).forEach(i -> res.append(e.getKey()));
            
        });
        
        return res.toString();
    }
    
    public static void main(String[] args) {
        
        FrequencySort obj = new FrequencySort();
        System.out.println(obj.frequencySort("aaabbbbbc"));
        
    }
    
}
