package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 * @author cck
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            
            String tempStr = String.valueOf(cs);
            
            List<String> list = map.getOrDefault(tempStr, new ArrayList<>());
            list.add(str);
            map.put(tempStr, list);
        }
        
        return new ArrayList<>(map.values());
    }
    
    public static void main(String[] args) {
        
        GroupAnagrams obj = new GroupAnagrams();
        
        System.out.println(obj.groupAnagrams(new String[]{}));
        System.out.println(obj.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        
    }
    
}
